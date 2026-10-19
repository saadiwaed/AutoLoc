package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@AllArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule v) { return vehiculeService.addVehicule(v); }

    @GetMapping
    public List<Vehicule> getAll() { return vehiculeService.retrieveAllVehicules(); }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) { return vehiculeService.retrieveVehicule(id); }

    @PutMapping
    public Vehicule update(@RequestBody Vehicule v) { return vehiculeService.updateVehicule(v); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { vehiculeService.removeVehicule(id); }
}