package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@AllArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    public Contrat add(@RequestBody Contrat c) { return contratService.addContrat(c); }

    @GetMapping
    public List<Contrat> getAll() { return contratService.retrieveAllContrats(); }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) { return contratService.retrieveContrat(id); }

    @PutMapping
    public Contrat update(@RequestBody Contrat c) { return contratService.updateContrat(c); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { contratService.removeContrat(id); }
}