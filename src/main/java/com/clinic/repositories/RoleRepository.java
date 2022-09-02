package com.clinic.repositories;

import com.clinic.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Set<Role> findByName(String name);
}
