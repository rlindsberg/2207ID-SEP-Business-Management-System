package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SEP.BusinessManagementSystem.Repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }
    public List<Client> getAllClients() {
//        return List.of(
//                new Client(
//                        1,
//                        "Ivar Jacobson",
//                        "070 123 4567"
//                )
//        );
        return clientRepository.findAll();
    }
}
