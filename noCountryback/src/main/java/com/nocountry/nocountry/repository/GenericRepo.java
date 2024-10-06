package com.nocountry.nocountry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface GenericRepo<T,ID> extends JpaRepository<T,ID> {

    @Query("UPDATE #{#entityName} e SET e=:t WHERE e.id=:id ")
    Optional<T> updateById(T t, ID id);
}
