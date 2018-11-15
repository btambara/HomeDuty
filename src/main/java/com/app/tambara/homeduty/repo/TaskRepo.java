package com.app.tambara.homeduty.repo;

import com.app.tambara.homeduty.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
