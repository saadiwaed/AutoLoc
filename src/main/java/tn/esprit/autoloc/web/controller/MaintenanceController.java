package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@AllArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance add(@RequestBody Maintenance m) { return maintenanceService.addMaintenance(m); }

    @GetMapping
    public List<Maintenance> getAll() { return maintenanceService.retrieveAllMaintenances(); }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) { return maintenanceService.retrieveMaintenance(id); }

    @PutMapping
    public Maintenance update(@RequestBody Maintenance m) { return maintenanceService.updateMaintenance(m); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { maintenanceService.removeMaintenance(id); }
}