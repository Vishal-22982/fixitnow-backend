package com.fixitnow.controller;

import com.fixitnow.model.ServiceRequest;
import com.fixitnow.service.ServiceRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class ServiceRequestController {

    private final ServiceRequestService service;

    public ServiceRequestController(ServiceRequestService service) {
        this.service = service;
    }

    // CREATE REQUEST
    @PostMapping("/{userId}")
    public ServiceRequest create(@PathVariable Long userId,
                                 @RequestBody ServiceRequest request) {
        return service.createRequest(userId, request);
    }

    // GET ALL REQUESTS
    @GetMapping
    public List<ServiceRequest> getAll() {
        return service.getAllRequests();
    }

    // UPDATE STATUS
    @PutMapping("/{id}")
    public ServiceRequest updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRequest(id);
        return "Request deleted";
    }
}