package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion Agence", description = "API de gestion des agences AutoLoc")
@RestController
@RequestMapping("/agences")
@AllArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "Récupérer toutes les agences", description = "Retourne la liste complète des agences.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne", content = @Content)
    })
    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Récupérer une agence par ID", description = "Retourne l'agence correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence trouvée",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class))}),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable("id") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @Operation(summary = "Créer une nouvelle agence", description = "Enregistre une nouvelle agence dans la base.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agence créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides", content = @Content)
    })
    @PostMapping
    public Agence addAgence(@RequestBody Agence a) {
        return agenceService.addAgence(a);
    }

    @Operation(summary = "Mettre à jour une agence", description = "Modifie les données d'une agence existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence mise à jour"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public Agence updateAgence(@PathVariable("id") Long idAgence, @RequestBody Agence a) {
        a.setIdAgence(idAgence);
        return agenceService.updateAgence(a);
    }

    @Operation(summary = "Supprimer une agence", description = "Supprime l'agence correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Agence supprimée", content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable("id") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}