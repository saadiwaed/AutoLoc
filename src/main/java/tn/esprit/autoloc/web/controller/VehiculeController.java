package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion Véhicule", description = "API de gestion des véhicules AutoLoc")
@RestController
@RequestMapping("/vehicules")
@AllArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Récupérer tous les véhicules", description = "Retourne la liste complète des véhicules de la base.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur", content = @Content)
    })
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par son ID", description = "Retourne le véhicule correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class))}),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable("id") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @Operation(summary = "Créer un nouveau véhicule", description = "Enregistre un nouveau véhicule dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides", content = @Content)
    })
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return vehiculeService.addVehicule(v);
    }

    @Operation(summary = "Mettre à jour un véhicule", description = "Modifie les données d'un véhicule existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule mis à jour"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable("id") Long idVehicule, @RequestBody Vehicule v) {
        v.setIdVehicule(idVehicule);
        return vehiculeService.updateVehicule(v);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime le véhicule correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable("id") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }
}