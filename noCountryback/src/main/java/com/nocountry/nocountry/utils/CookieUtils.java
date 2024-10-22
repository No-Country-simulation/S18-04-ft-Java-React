package com.nocountry.nocountry.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.util.SerializationUtils;

import java.util.Base64;
import java.util.Optional;

public class CookieUtils {
//    public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
//        Cookie[] cookies = request.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(name)) {
//                    return Optional.of(cookie);
//                }
//            }
//        }
//
//        return Optional.empty();
//    }
public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return Optional.of(cookie);
            }
        }
    }
    return Optional.empty();
}
//    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        cookie.setMaxAge(maxAge);
//
//        // Construcción manual de encabezado para SameSite y Domain
//        String domain = "nocountry.up.railway.app"; // Cambia esto según el entorno o hazlo configurable
//        String sameSite = "None"; // Cambia a "None" si necesitas compartir cookies entre diferentes dominios
//
//        // Aquí agregamos manualmente SameSite y Domain en el encabezado Set-Cookie
//        String cookieHeader = String.format("%s=%s; Max-Age=%d; Path=%s; HttpOnly; Secure; SameSite=%s; Domain=%s",
//                name, value, maxAge, cookie.getPath(), sameSite, domain);
//        response.addHeader("Set-Cookie", cookieHeader);
//    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
//        ResponseCookie cokiePrueba = ResponseCookie.from( name,value )
//                .httpOnly( true )
//                .sameSite( "None" )
//                .secure( true )
//                .path( "/" )
//                .maxAge( maxAge )
//                .domain( "no-country.up.railway.app" )
//                .build();
//        response.setHeader( HttpHeaders.SET_COOKIE, cokiePrueba.toString() );
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setHttpOnly(false);
        cookie.setSecure(true);
        cookie.setMaxAge(maxAge);
        response.addCookie( cookie );


    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }


    public static String serialize(Object object) {
        return Base64
                .getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(object));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(SerializationUtils.deserialize(
                Base64
                        .getUrlDecoder()
                        .decode(cookie.getValue())));
    }

}
