package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Request;
import com.SEP.BusinessManagementSystem.Service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/get-all")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }
    @PutMapping("/create")
    public ResponseEntity<?> createNewRequest(@RequestBody Request requestDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("requests/create").toUriString());
        return ResponseEntity.created(uri).body(requestService.createNewRequest(requestDetails));
    }
    @PutMapping("/{id}/SCS/review/approve")
    public ResponseEntity<?> approveRequestBySCSById(@PathVariable Long id){
        return ResponseEntity.ok().body(requestService.approveRequestBySCSById(id));
    }

    @PutMapping("/{id}/SCS/review/reject")
    public ResponseEntity<?> rejectRequestBySCSById(@PathVariable Long id){
        return ResponseEntity.ok().body(requestService.rejectRequestBySCSById(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRequestById(@PathVariable Long id){
        return ResponseEntity.ok().body(requestService.getRequestById(id));
    }
}
