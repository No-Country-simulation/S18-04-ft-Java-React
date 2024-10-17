package com.nocountry.nocountry.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {

    private final Auth auth = new Auth();
    private final OAuth2 oAuth2 = new OAuth2();

    @Getter
    @Setter
    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;
    }

    @Setter
    @Getter
    public static final class OAuth2 {
        @Value("${authorized.redirect.uri}")
        private String redirectUri;
//        private List<String> authorizedRedirectUris = List.of(this.redirectUri);
        private List<String> authorizedRedirectUris = List.of("https://nocountry.up.railway.app");

        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
            this.authorizedRedirectUris = authorizedRedirectUris;
            return this;
        }
    }
}
