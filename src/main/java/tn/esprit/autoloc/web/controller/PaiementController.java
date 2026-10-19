package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@AllArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    public Paiement add(@RequestBody Paiement p) { return paiementService.addPaiement(p); }

    @GetMapping
    public List<Paiement> getAll() { return paiementService.retrieveAllPaiements(); }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) { return paiementService.retrievePaiement(id); }

    @PutMapping
    public Paiement update(@RequestBody Paiement p) { return paiementService.updatePaiement(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { paiementService.removePaiement(id); }
}