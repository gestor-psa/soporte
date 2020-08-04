package psa.soporte.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psa.soporte.excepcion.TicketNoEncontradoExcepcion;
import psa.soporte.modelo.Ticket;
import psa.soporte.repositorio.TicketRepositorio;

import java.util.Date;
import java.util.List;


@Service
public class TicketServicio {

    @Autowired
    private TicketRepositorio repositorio;

    public List<Ticket> listarTickets() {
        return repositorio.findAll();
    }

    public Ticket crear(Ticket nuevoTicket) {
        return repositorio.save(nuevoTicket);
    }

    public Ticket obtener(Long id) throws TicketNoEncontradoExcepcion {
        return repositorio.findById(id).orElseThrow(() -> new TicketNoEncontradoExcepcion(id));
    }

    public Ticket actualizar(Long id, Ticket nuevoTicket) {
        return repositorio.findById(id)
                .map(ticket -> {
                    ticket.setNombre(nuevoTicket.getNombre());
                    ticket.setTipo(nuevoTicket.getTipo());
                    ticket.setEstado(nuevoTicket.getEstado());
                    if (ticket.getEstado().equals("pendiente") || ticket.getEstado().equals("iniciado")){
                        ticket.setFechaDeCierre(null);
                    }
                    else {
                        ticket.setFechaDeCierre(new Date());
                    }
                    ticket.setDescripcion(nuevoTicket.getDescripcion());
                    ticket.setSeveridad(nuevoTicket.getSeveridad());
                    ticket.setResponsableDni(nuevoTicket.getResponsableDni());
                    ticket.setCliente(nuevoTicket.getCliente());
                    ticket.setFechaDeActualizacion(new Date());
                    return repositorio.save(ticket);
                })
                .orElseGet(() -> {
                    throw new TicketNoEncontradoExcepcion(id);
                });
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}