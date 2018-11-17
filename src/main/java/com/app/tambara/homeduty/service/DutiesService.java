package com.app.tambara.homeduty.service;

import com.app.tambara.homeduty.domain.Duties;
import com.app.tambara.homeduty.repo.DutiesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DutiesService {
    private final DutiesRepo dutiesRepo;

    public DutiesService(DutiesRepo dutiesRepo, TaskService taskService) {
        this.dutiesRepo = dutiesRepo;
    }

    public List<Duties> getAllDuties() {
        return dutiesRepo.findAll();
    }

    public void deleteTask(long dutiesID){
        dutiesRepo.deleteById(dutiesID);
    }

    public List<Duties> getDutiesForUserID(long userID) {
        return dutiesRepo.findAllByOwnerID(userID);
    }
}
