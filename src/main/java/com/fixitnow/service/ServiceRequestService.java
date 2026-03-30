package com.fixitnow.service;

import com.fixitnow.model.ServiceRequest;
import com.fixitnow.model.User;
import com.fixitnow.model.Mechanic;
import com.fixitnow.repository.ServiceRequestRepository;
import com.fixitnow.repository.UserRepository;
import com.fixitnow.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository repository;
    private final UserRepository userRepository;
    private final MechanicRepository mechanicRepository;

    public ServiceRequestService(ServiceRequestRepository repository,
                                 UserRepository userRepository,
                                 MechanicRepository mechanicRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mechanicRepository = mechanicRepository;
    }

    // 🔥 CREATE WITH AUTO ASSIGN
    public ServiceRequest createRequest(Long userId, ServiceRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Mechanic mechanic = mechanicRepository.findFirstByStatus("AVAILABLE")
                .orElseThrow(() -> new RuntimeException("No mechanic available"));

        request.setUser(user);
        request.setMechanic(mechanic);
        request.setStatus("ACCEPTED");

        mechanic.setStatus("BUSY");

        return repository.save(request);
    }

    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    public ServiceRequest updateStatus(Long id, String status) {

        ServiceRequest request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(status);

        // 🔥 IF COMPLETED → FREE MECHANIC
        if (status.equalsIgnoreCase("COMPLETED")) {
            Mechanic mechanic = request.getMechanic();
            if (mechanic != null) {
                mechanic.setStatus("AVAILABLE");
            }
        }

        return repository.save(request);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}