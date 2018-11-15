package com.app.tambara.homeduty.repo;

import com.app.tambara.homeduty.domain.Duties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DutiesRepo extends JpaRepository<Duties, Long> {
    List<Duties> findAllByOwnerID(Long ownerID);
}
