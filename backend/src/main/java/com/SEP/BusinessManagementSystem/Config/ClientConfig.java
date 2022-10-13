package com.SEP.BusinessManagementSystem.Config;

import com.SEP.BusinessManagementSystem.Entity.Client;
import com.SEP.BusinessManagementSystem.Repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
            Client ivarJacobson = new Client(
                    1,
                    "Ivar Jacobson",
                    "070 123 4567"
            );
            repository.saveAll(
                    List.of(ivarJacobson)
            );
        };

    }

}
