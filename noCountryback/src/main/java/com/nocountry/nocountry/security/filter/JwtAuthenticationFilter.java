package com.nocountry.nocountry.security.filter;

import com.nocountry.nocountry.exceptions.UnAuthorizedException;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.UserRepo;
import com.nocountry.nocountry.security.CustomUserDetailsService;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import com.nocountry.nocountry.utils.CookieUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;
    private final UserRepo userRepo;

    public JwtAuthenticationFilter(UserRepo userRepo, JwtUtils jwtUtils, CustomUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.userRepo = userRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String token = getTokenFromRequest(request);
        Optional<Cookie> cookie = CookieUtils.getCookie(request, "token");
        if(cookie.isEmpty()) {
            filterChain.doFilter(request, response);
            return ;
        }
        final String username;
        String token = cookie.get().getValue();

        if(token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        username = jwtUtils.getUsernameFromToken(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User userEntity = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found",username)));

            UserDetails user = UserPrincipal.create(userEntity);

            if(jwtUtils.isTokenValid(token, user)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                CookieUtils.deleteCookie(request, response, "token");
            }

        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
}
