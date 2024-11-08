package com.nocountry.nocountry.security.oauth2;

import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Role;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.RoleRepo;
import com.nocountry.nocountry.repository.UserRepo;
import com.nocountry.nocountry.security.oauth2.exceptions.OAuth2AuthenticationProcessingException;
import com.nocountry.nocountry.security.oauth2.user.UserInfoOAuth;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepository;
    private final RoleRepo roleRepo;

    public CustomOAuth2UserService(UserRepo userRepository, RoleRepo roleRepo) {
        this.userRepository = userRepository;
        this.roleRepo = roleRepo;
    }
    @Transactional
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }
    @Transactional
    protected OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        UserInfoOAuth userInfoOAuth = new UserInfoOAuth(oAuth2User.getAttributes());
        if (StringUtils.isEmpty(userInfoOAuth.getEmail())) {
            log.error("Email not found from OAuth2 provider");
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }
        Optional<User> userOptional = userRepository.findByEmail(userInfoOAuth.getEmail());
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = new User();
            user.setEmail(userInfoOAuth.getEmail());
            user.setRoles(new ArrayList<>());
            Role role = roleRepo.findById(UUID.fromString("340ddc49-1214-4e00-9a77-2334334b23d3")).orElseThrow(() -> new NotFoundException("Role not found"));
            user.getRoles().add(role);
            userRepository.save(user);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }
}