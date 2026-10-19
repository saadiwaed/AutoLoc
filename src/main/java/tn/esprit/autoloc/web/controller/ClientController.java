package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final IClientService clientService; // On injecte l'INTERFACE

    @PostMapping
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.retrieveClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client c) {
        c.setIdClient(id); // On s'assure que l'ID correspond
        return clientService.updateClient(c);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.removeClient(id);
    }
}