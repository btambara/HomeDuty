package com.app.tambara.homeduty.repo;

import com.app.tambara.homeduty.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
