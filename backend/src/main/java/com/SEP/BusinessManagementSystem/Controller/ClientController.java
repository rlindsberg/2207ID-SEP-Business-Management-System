package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Client;
import com.SEP.BusinessManagementSystem.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService studentService) {
        this.clientService = studentService;
    }

    @GetMapping("get-all")
    public List<Client> getAllClients() {

        return clientService.getAllClients();
    }

    @PutMapping("/update-phone-number")
    public ResponseEntity<?> updatePhoneNumber(Long clientID, String phoneNumber) {
        return ResponseEntity.ok().body(clientService.updatePhoneNumber(clientID, phoneNumber));
    }
}
