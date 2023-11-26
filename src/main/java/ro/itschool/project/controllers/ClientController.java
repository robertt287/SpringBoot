package ro.itschool.project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.project.models.entities.Client;
import ro.itschool.project.services.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createUser(@RequestBody @Valid Client client) {
        return ResponseEntity.ok(clientService.createUser(client));
    }
}
