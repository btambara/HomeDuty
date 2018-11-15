package com.app.tambara.homeduty.controller;

import com.app.tambara.homeduty.domain.Duties;
import com.app.tambara.homeduty.domain.Task;
import com.app.tambara.homeduty.service.DutiesService;
import com.app.tambara.homeduty.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeDutyController {
    private final TaskService taskService;
    private final DutiesService dutiesService;

    public HomeDutyController(TaskService taskService, DutiesService dutiesService) {
        this.taskService = taskService;
        this.dutiesService = dutiesService;
    }

    @GetMapping(value = {"/", "/index"})
    public String getIndexPage(Model model) {
        List<Duties> dutiesForUserID = dutiesService.getDutiesForUserID(2);
        List<Task> tasksForUserID = new ArrayList<>();
        dutiesForUserID.forEach(duties -> tasksForUserID.add(taskService.getTask(duties.getDutyID())));
        model.addAttribute("tasksForUserID", tasksForUserID);
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String getAdminPage(Model model) {
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
