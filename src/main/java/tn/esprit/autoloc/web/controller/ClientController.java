package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion Client", description = "API de gestion des clients AutoLoc")
@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @Operation(summary = "Récupérer tous les clients", description = "Retourne la liste complète des clients.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne", content = @Content)
    })
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Récupérer un client par ID", description = "Retourne le client correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @Operation(summary = "Créer un nouveau client", description = "Enregistre un nouveau client dans la base.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides", content = @Content)
    })
    @PostMapping
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @Operation(summary = "Mettre à jour un client", description = "Modifie les données d'un client existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client mis à jour"),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long idClient, @RequestBody Client c) {
        c.setIdClient(idClient);
        return clientService.updateClient(c);
    }

    @Operation(summary = "Supprimer un client", description = "Supprime le client correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long idClient) {
        clientService.removeClient(idClient);
    }
}