package com.fixitnow.service;

import com.fixitnow.model.Mechanic;
import com.fixitnow.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService {

    private final MechanicRepository repository;

    public MechanicService(MechanicRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Mechanic addMechanic(Mechanic mechanic) {
        return repository.save(mechanic);
    }

    // GET ALL
    public List<Mechanic> getAllMechanics() {
        return repository.findAll();
    }
}