package psa.soporte.mapeador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import psa.soporte.excepcion.ClienteNoEncontradoExcepcion;
import psa.soporte.modelo.Ticket;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.vista.ticket.TicketVistaActualizar;
import psa.soporte.vista.ticket.TicketVistaCrear;
import psa.soporte.vista.ticket.TicketVistaMostrar;

@Component
public class TicketMapeador {

    @Autowired
    private ClienteServicio clienteServicio;

    public Ticket mapear(TicketVistaCrear ticketVista) throws ClienteNoEncontradoExcepcion {
        Ticket ticket = new Ticket();
        ticket.setNombre(ticketVista.getNombre());
        ticket.setDescripcion(ticketVista.getDescripcion());
        ticket.setTipo(ticketVista.getTipo());
        ticket.setSeveridad(ticketVista.getSeveridad());
        ticket.setResponsableDni(ticketVista.getResponsableDni());
        ticket.setCliente(clienteServicio.obtener(ticketVista.getClienteId()));
        return ticket;
    }

    public Ticket mapear(TicketVistaActualizar ticketVista) throws ClienteNoEncontradoExcepcion {
        Ticket ticket = new Ticket();
        ticket.setNombre(ticketVista.getNombre());
        ticket.setDescripcion(ticketVista.getDescripcion());
        ticket.setTipo(ticketVista.getTipo());
        ticket.setSeveridad(ticketVista.getSeveridad());
        ticket.setResponsableDni(ticketVista.getResponsableDni());
        ticket.setEstado(ticketVista.getEstado());
        ticket.setCliente(clienteServicio.obtener(ticketVista.getClienteId()));
        return ticket;
    }

    public TicketVistaMostrar mapear(Ticket ticket) {
        TicketVistaMostrar ticketVista = new TicketVistaMostrar();
        ticketVista.setId(ticket.getId());
        ticketVista.setNombre(ticket.getNombre());
        ticketVista.setDescripcion(ticket.getDescripcion());
        ticketVista.setTipo(ticket.getTipo());
        ticketVista.setSeveridad(ticket.getSeveridad());
        ticketVista.setResponsableDni(ticket.getResponsableDni());
        ticketVista.setEstado(ticket.getEstado());
        ticketVista.setFechaDeCreacion(ticket.getFechaDeCreacion());
        ticketVista.setFechaDeActualizacion(ticket.getFechaDeActualizacion());
        ticketVista.setFechaDeCierre(ticket.getFechaDeCierre());
        ticketVista.setCliente(ticket.getCliente());
        return ticketVista;
    }
}
