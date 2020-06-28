package psa.soporte.service;

import org.springframework.stereotype.Service;
import psa.soporte.exception.TicketNotFoundException;
import psa.soporte.model.Ticket;
import psa.soporte.repository.TicketRepository;

import java.util.List;


@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository ticketRepository) {
        this.repository = ticketRepository;
    }

    public List<Ticket> listarTickets() {
        return repository.findAll();
    }

    public Ticket crearTicket(Ticket nuevoTicket) {
        if(!tieneCamposRequeridos(nuevoTicket)){
            return null;
        }
        return repository.save(nuevoTicket);
    }

    public Ticket obtenerTicket(Long id) throws TicketNotFoundException {
        return repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    public Ticket actualizarTicket(Ticket nuevoTicket, Long id) {
        if(!tieneCamposRequeridos(nuevoTicket)){
            return null;
        }
        return repository.findById(id)
                .map(ticket -> {
                    ticket.setNombre(nuevoTicket.getNombre());
                    ticket.setTipo(nuevoTicket.getTipo());
                    ticket.setEstado(nuevoTicket.getEstado());
                    ticket.setDescripcion(nuevoTicket.getDescripcion());
                    ticket.setSeveridad(nuevoTicket.getSeveridad());
                    ticket.setResponsable(nuevoTicket.getResponsable());
                    ticket.setComentarios(nuevoTicket.getComentarios());
                    ticket.setCliente(nuevoTicket.getCliente());
                    return repository.save(ticket);
                })
                .orElseGet(() -> {
                    nuevoTicket.setId(id);
                    return repository.save(nuevoTicket);
                });
    }

    public void eliminarTicket(Long id) {
        repository.deleteById(id);
    }

    private boolean tieneCamposRequeridos(Ticket newTicket) {
        if(newTicket.getNombre() == null || newTicket.getDescripcion() == null || newTicket.getTipo() == null || newTicket.getSeveridad() == null) {
            return false;
        }
        return true;
    }

}