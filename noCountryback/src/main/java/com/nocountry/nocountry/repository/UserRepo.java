package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends GenericRepo<User,UUID> {
    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}