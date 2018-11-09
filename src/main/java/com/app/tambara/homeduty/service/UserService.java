package com.app.tambara.homeduty.service;

import com.app.tambara.homeduty.domain.User;
import com.app.tambara.homeduty.repo.UserRepo;
import com.app.tambara.homeduty.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("This username " + "[ " + username + " ] does not exist");
        }

        return new UserPrincipal(user);
    }
}
