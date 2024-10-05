package com.nocountry.nocountry.security.filter;

import com.nocountry.nocountry.dto.response.ErrorResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class JwtUtils {

    @Value("${jwt.secret}")
    private  String JWT_SECRET;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;


    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes());
    }

    public Date expiration() {return new Date(System.currentTimeMillis() + JWT_EXPIRATION);}

    public String createToke(String username, Map<String, Object> claims) {

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .expiration(expiration())
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getKey())
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("roles",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return createToke(userDetails.getUsername() , claims);
    }


    public <T> T getClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException | MalformedJwtException e) {
            throw e;
        } catch (SignatureException e) {
            ErrorResponseDTO error = new ErrorResponseDTO("Invalid token", "Token is invalid or tampered with");
            throw new RuntimeException(String.valueOf(error));
        } catch (Exception e) {
            ErrorResponseDTO error = new ErrorResponseDTO("Internal Server Error", "Error interno del servidor");
            throw new RuntimeException(String.valueOf(error));
        }
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {

        return getExpiration(token).before(new Date());
    }

    public String createTokenConfirmation(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(getKey())
                .compact();
    }
}
