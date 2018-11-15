package com.app.tambara.homeduty.service;

import com.app.tambara.homeduty.domain.Task;
import com.app.tambara.homeduty.repo.TaskRepo;
import org.springframework.stereotype.Service;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTask(Long taskID) {
        return taskRepo.findById(taskID).get();
    }
}
