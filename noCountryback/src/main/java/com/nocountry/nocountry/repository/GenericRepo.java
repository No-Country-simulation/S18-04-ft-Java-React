package com.nocountry.nocountry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepo<T,ID> extends JpaRepository<T,ID> {
}
