package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.SEP.BusinessManagementSystem.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

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

    public void updatePhoneNumber(Long clientId, String phoneNumber) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new RuntimeException("Client not found!");
        }
        Client client = clientOptional.get();
        client.setPhoneNumber(phoneNumber);
        clientRepository.save(client);
    }
}
