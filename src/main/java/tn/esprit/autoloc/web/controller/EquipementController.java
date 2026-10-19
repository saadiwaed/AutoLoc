package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@AllArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public Equipement add(@RequestBody Equipement e) { return equipementService.addEquipement(e); }

    @GetMapping
    public List<Equipement> getAll() { return equipementService.retrieveAllEquipements(); }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) { return equipementService.retrieveEquipement(id); }

    @PutMapping
    public Equipement update(@RequestBody Equipement e) { return equipementService.updateEquipement(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { equipementService.removeEquipement(id); }
}