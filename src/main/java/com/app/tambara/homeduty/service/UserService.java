package com.app.tambara.homeduty.service;

import com.app.tambara.homeduty.domain.User;
import com.app.tambara.homeduty.repo.UserRepo;
import com.app.tambara.homeduty.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getAllUsersWithRole(String role) {
        return userRepo.findAllByRole(role);
    }

    public User getUser(long userID) {
        if (userRepo.findById(userID).isPresent()) {
            return userRepo.findById(userID).get();
        }

        throw new UsernameNotFoundException("This user ID" + "[ " + userID + " ] does not exist");
    }

    public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("This username " + "[ " + username + " ] does not exist");
        }

        return user;
    }
}
