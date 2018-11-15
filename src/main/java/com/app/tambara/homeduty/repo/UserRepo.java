package com.app.tambara.homeduty.repo;

import com.app.tambara.homeduty.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAllByRole(String role);
}
