package com.stackroute.authenticationserver.repository;

import com.stackroute.authenticationserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, String> {

    Users findByUsername(String username);

}
