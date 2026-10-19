package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@AllArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence add(@RequestBody Agence a) { return agenceService.addAgence(a); }

    @GetMapping
    public List<Agence> getAll() { return agenceService.retrieveAllAgences(); }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) { return agenceService.retrieveAgence(id); }

    @PutMapping
    public Agence update(@RequestBody Agence a) { return agenceService.updateAgence(a); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { agenceService.removeAgence(id); }
}