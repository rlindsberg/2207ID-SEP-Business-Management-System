package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/getAllClients")
public class ClientController {

    @GetMapping
    public List<Client> getAllClients() {
        return List.of(
                new Client(
                        1,
                        "Ivar Jacobson",
                        "070 123 4567"
                )
        );
    }
}
