package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@AllArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe add(@RequestBody Employe e) { return employeService.addEmploye(e); }

    @GetMapping
    public List<Employe> getAll() { return employeService.retrieveAllEmployes(); }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) { return employeService.retrieveEmploye(id); }

    @PutMapping
    public Employe update(@RequestBody Employe e) { return employeService.updateEmploye(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { employeService.removeEmploye(id); }
}