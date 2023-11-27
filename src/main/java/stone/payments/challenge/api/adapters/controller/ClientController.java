package stone.payments.challenge.api.adapters.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stone.payments.challenge.api.adapters.dto.ClientDTO;
import stone.payments.challenge.api.core.bussinesRule.ClientBussines;
import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.infrastructure.exception.ClientAlReadyRegisteredException;

@RestController
@RequestMapping
@SecurityRequirement(name = "bearer-key")

public class ClientController {

    @Autowired
    private ClientBussines clientBussines;

    @PostMapping("/client")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ClientDTO data) throws ClientAlReadyRegisteredException {
        Client newClient = new Client(data);
        var client = clientBussines.createClient(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/clients")
    public ResponseEntity getAllClients() {
        var client = clientBussines.getAllClients();
        return ResponseEntity.ok(client);
    }
}
