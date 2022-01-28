package com.csriseupapi.csriseupapi.repository;

import com.csriseupapi.csriseupapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
