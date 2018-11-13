package com.app.tambara.homeduty.controller;

import com.app.tambara.homeduty.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SecurityTestController {
    final private UserRepo userRepo;

    public SecurityTestController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(value = {"/", "/index"})
    public String getIndexPage(Model model) {
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String getAdminPage(Model model) {
        userRepo.findAll().forEach(user -> System.out.println("ID:" + user.getId() + "Username: " + user.getUsername() + " Password: " + user.getPassword()));
        return "admin";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String getLogoutPage(Model model) {
        return "logout";
    }
}
