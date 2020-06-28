package psa.soporte.controller;

import org.springframework.web.bind.annotation.*;
import psa.soporte.model.Ticket;
import psa.soporte.service.TicketService;

import java.util.List;


@RestController
public
class TicketController {

    private TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Aggregate root

    @GetMapping("/tickets")
    public List<Ticket> all() {
        return ticketService.listarTickets();
    }

    @PostMapping("/tickets")
    public Ticket newTicket(@RequestBody Ticket newTicket) {
        return ticketService.crearTicket(newTicket);
    }

    // Single item

    @GetMapping("/tickets/{id}")
    public Ticket one(@PathVariable Long id) {
        return ticketService.obtenerTicket(id);
    }

    @PutMapping("/tickets/{id}")
    public Ticket replaceTicket(@RequestBody Ticket newTicket, @PathVariable Long id) {
        return ticketService.actualizarTicket(newTicket,id);
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
    }
}