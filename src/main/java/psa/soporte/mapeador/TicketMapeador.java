package psa.soporte.mapeador;

import org.springframework.stereotype.Component;
import psa.soporte.modelo.Ticket;
import psa.soporte.vista.TicketVistaActualizar;
import psa.soporte.vista.TicketVistaCrear;
import psa.soporte.vista.TicketVistaMostrar;

@Component
public class TicketMapeador {

    public Ticket mapear(TicketVistaCrear ticketVista) {
        Ticket ticket = new Ticket();
        ticket.setNombre(ticketVista.getNombre());
        ticket.setDescripcion(ticketVista.getDescripcion());
        ticket.setTipo(ticketVista.getTipo());
        ticket.setSeveridad(ticketVista.getSeveridad());
        ticket.setResponsable(ticketVista.getResponsable());
        return ticket;
    }

    public Ticket mapear(TicketVistaActualizar ticketVista) {
        Ticket ticket = new Ticket();
        ticket.setNombre(ticketVista.getNombre());
        ticket.setDescripcion(ticketVista.getDescripcion());
        ticket.setTipo(ticketVista.getTipo());
        ticket.setSeveridad(ticketVista.getSeveridad());
        ticket.setResponsable(ticketVista.getResponsable());
        ticket.setEstado(ticketVista.getEstado());
        return ticket;
    }

    public TicketVistaMostrar mapear(Ticket ticket) {
        TicketVistaMostrar ticketVista = new TicketVistaMostrar();
        ticketVista.setId(ticket.getId());
        ticketVista.setNombre(ticket.getNombre());
        ticketVista.setDescripcion(ticket.getDescripcion());
        ticketVista.setTipo(ticket.getTipo());
        ticketVista.setNombre(ticket.getNombre());
        ticketVista.setSeveridad(ticket.getSeveridad());
        ticketVista.setResponsable(ticket.getResponsable());
        ticketVista.setEstado(ticket.getEstado());
        ticketVista.setFechaDeCreacion(ticket.getFechaDeCreacion());
        ticketVista.setFechaDeActualizacion(ticket.getFechaDeActualizacion());
        return ticketVista;
    }
}
