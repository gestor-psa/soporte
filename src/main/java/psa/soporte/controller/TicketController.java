package psa.soporte.controller;

import org.springframework.web.bind.annotation.*;
import psa.soporte.exception.TicketNotFoundException;
import psa.soporte.model.Ticket;
import psa.soporte.repository.TicketRepository;

import java.util.List;


@RestController
public
class TicketController {

    private final TicketRepository repository;

    TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/tickets")
    List<Ticket> all() {
        return repository.findAll();
    }

    @PostMapping("/tickets")
    Ticket newTicket(@RequestBody Ticket newTicket) {
        return repository.save(newTicket);
    }

    // Single item

    @GetMapping("/tickets/{id}")
    Ticket one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }

    @PutMapping("/tickets/{id}")
    Ticket replaceTicket(@RequestBody Ticket newTicket, @PathVariable Long id) {

        return repository.findById(id)
                .map(ticket -> {
                    ticket.setName(newTicket.getName());
                    //ticket.setRole(newTicket.getRole());
                    return repository.save(ticket);
                })
                .orElseGet(() -> {
                    newTicket.setId(id);
                    return repository.save(newTicket);
                });
    }

    @DeleteMapping("/tickets/{id}")
    void deleteTicket(@PathVariable Long id) {
        repository.deleteById(id);
    }
}