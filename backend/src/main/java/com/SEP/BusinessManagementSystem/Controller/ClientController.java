package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Client;
import com.SEP.BusinessManagementSystem.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService studentService) {
        this.clientService = studentService;
    }

    @GetMapping("get-all")
    public List<Client> getAllClients() {

        return clientService.getAllClients();
    }

    @PutMapping("/update-phone-number/{id}")
    public ResponseEntity<?> updatePhoneNumber(@PathVariable(value = "id") Long userId, @RequestBody Client clientDetails) {
        String phoneNumberToBeUpdated = clientDetails.getPhoneNumber();
        return ResponseEntity.ok().body(clientService.updatePhoneNumber(userId, phoneNumberToBeUpdated));
    }
}
