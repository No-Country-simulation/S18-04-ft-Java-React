package com.nocountry.nocountry.security;

import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepository;
    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with email: %s", username)));
        return null;
    }

    public UserDetails loadUserById(UUID id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with ID: %s.", id)));

//        return UserPrincipal.create(user);
        return null;
    }

}
