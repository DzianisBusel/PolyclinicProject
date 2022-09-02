package com.clinic.repositories;

import com.clinic.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :login")
    User getUserByLogin(@Param("login") String login);

    @Query("SELECT u FROM User u WHERE u.specialization IS NOT NULL")
    List<User> getUsersBySpezialization();

}
