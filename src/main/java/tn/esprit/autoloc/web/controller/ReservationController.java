package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation add(@RequestBody Reservation r) { return reservationService.addReservation(r); }

    @GetMapping
    public List<Reservation> getAll() { return reservationService.retrieveAllReservations(); }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Long id) { return reservationService.retrieveReservation(id); }

    @PutMapping
    public Reservation update(@RequestBody Reservation r) { return reservationService.updateReservation(r); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { reservationService.removeReservation(id); }
}