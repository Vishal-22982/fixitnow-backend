package com.fixitnow.controller;

import com.fixitnow.model.Mechanic;
import com.fixitnow.service.MechanicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    private final MechanicService service;

    public MechanicController(MechanicService service) {
        this.service = service;
    }

    // CREATE MECHANIC
    @PostMapping
    public Mechanic add(@RequestBody Mechanic mechanic) {
        return service.addMechanic(mechanic);
    }

    // GET ALL
    @GetMapping
    public List<Mechanic> getAll() {
        return service.getAllMechanics();
    }
}