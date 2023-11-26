package ro.itschool.project.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.entities.Client;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final EmailService emailService;
    private final Map<Long, Client> users = new HashMap<>();

    public Client createUser(Client client) {

        long userId = users.size() + 1L;
        client.setId(userId);

        users.put(client.getId(), client);

        emailService.sendAccountCreationConfirmation(client);

        log.info("User with id {} has been created.", userId);

        return client;
    }
}
