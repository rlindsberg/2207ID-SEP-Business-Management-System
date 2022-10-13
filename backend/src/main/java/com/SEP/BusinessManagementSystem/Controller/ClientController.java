package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Client;
import com.SEP.BusinessManagementSystem.Service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/getAllClients")
public class ClientController {
    private final ClientService studentService;

    public ClientController(ClientService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Client> getAllClients() {

        return studentService.getAllClients();
    }
}
