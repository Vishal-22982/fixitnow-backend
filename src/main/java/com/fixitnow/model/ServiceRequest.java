package com.fixitnow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problem;
    private String location;
    private String status; // PENDING, ACCEPTED, COMPLETED

    // USER RELATION
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore   // prevents infinite loop
    private User user;

    // MECHANIC RELATION (ADD THIS)
    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    // Default constructor
    public ServiceRequest() {}

    // Constructor
    public ServiceRequest(Long id, String problem, String location, String status) {
        this.id = id;
        this.problem = problem;
        this.location = location;
        this.status = status;
    }

    //  GETTERS

    public Long getId() {
        return id;
    }

    public String getProblem() {
        return problem;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    // ================= SETTERS =================

    public void setId(Long id) {
        this.id = id;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}