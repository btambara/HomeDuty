package com.app.tambara.homeduty.controller;

import com.app.tambara.homeduty.domain.Duties;
import com.app.tambara.homeduty.domain.Task;
import com.app.tambara.homeduty.domain.User;
import com.app.tambara.homeduty.service.DutiesService;
import com.app.tambara.homeduty.service.TaskService;
import com.app.tambara.homeduty.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeDutyController {
    private final TaskService taskService;
    private final DutiesService dutiesService;
    private final UserService userService;

    public HomeDutyController(TaskService taskService, DutiesService dutiesService, UserService userService) {
        this.taskService = taskService;
        this.dutiesService = dutiesService;
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/index"})
    public String getIndexPage(Model model) {
        List<Duties> allDuties = dutiesService.getAllDuties();
        HashMap<User, List<Task>> userTaskMap = new HashMap<>();
        List<Task> taskHolder;

        for (Duties duties : allDuties) {
            if (!userTaskMap.containsKey(userService.getUser(duties.getOwnerID()))) {
                taskHolder = new ArrayList<>();
                taskHolder.add(taskService.getTask(duties.getTaskID()));
                userTaskMap.put(userService.getUser(duties.getOwnerID()), taskHolder);
            } else {
                userTaskMap.get(userService.getUser(duties.getOwnerID())).add(taskService.getTask(duties.getTaskID()));
            }
        }

        model.addAttribute("userTaskMap", userTaskMap);

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
