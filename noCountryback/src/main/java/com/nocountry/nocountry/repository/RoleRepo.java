package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.Role;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepo extends GenericRepo<Role, UUID> {
}
