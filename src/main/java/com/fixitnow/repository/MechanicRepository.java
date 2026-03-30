package com.fixitnow.repository;

import com.fixitnow.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

    // 🔥 Find first available mechanic
    Optional<Mechanic> findFirstByStatus(String status);

}