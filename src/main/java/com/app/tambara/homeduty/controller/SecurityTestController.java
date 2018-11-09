package com.app.tambara.homeduty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SecurityTestController {
    @GetMapping(value = {"/", "/index"})
    public String getIndexPage(Model model) {
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String getAdminPage(Model model) {
        return "admin";
    }
}
