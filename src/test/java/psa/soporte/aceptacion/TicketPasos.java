package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import psa.soporte.PsaApplication;
import psa.soporte.controlador.TicketControlador;
import psa.soporte.modelo.Cliente;
import psa.soporte.modelo.Ticket;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.servicio.TicketServicio;
import psa.soporte.vista.ticket.TicketVistaActualizar;
import psa.soporte.vista.ticket.TicketVistaCrear;
import psa.soporte.vista.ticket.TicketVistaMostrar;

import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = PsaApplication.class)
public class TicketPasos {

    @Autowired
    private Validator validator;

    @Autowired
    private TicketControlador ticketControlador;

    @Autowired
    private TicketServicio ticketServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    private Cliente clienteCreado;
    private TicketVistaMostrar ticket;


    @DataTableType
    public TicketVistaCrear definirTicketVistaCrear(Map<String, String> campos) {
        TicketVistaCrear ticketVista = new TicketVistaCrear();
        ticketVista.setNombre(campos.get("nombre"));
        ticketVista.setDescripcion(campos.get("descripcion"));
        try {
            ticketVista.setResponsableDni(Long.parseLong(campos.get("responsableDni")));
        } catch (NumberFormatException e) {
            ticketVista.setResponsableDni(null);
        }
        ticketVista.setTipo(campos.get("tipo"));
        ticketVista.setSeveridad(campos.get("severidad"));
        ticketVista.setClienteId(clienteCreado.getId());
        return ticketVista;
    }

    @DataTableType
    public TicketVistaMostrar definirTicketVistaMostrar(Map<String, String> campos) throws ParseException {
        TicketVistaMostrar ticketVista = new TicketVistaMostrar();
        ticketVista.setNombre(campos.get("nombre"));
        ticketVista.setDescripcion(campos.get("descripcion"));
        try {
            ticketVista.setResponsableDni(Long.parseLong(campos.get("responsableDni")));
        } catch (NumberFormatException e) {
            ticketVista.setResponsableDni(null);
        }
        ticketVista.setTipo(campos.get("tipo"));
        ticketVista.setSeveridad(campos.get("severidad"));
        ticketVista.setEstado(campos.get("estado"));

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDeCreacion;
        if (campos.get("fechaDeCreacion").equals("ahora")) {
            fechaDeCreacion = new Date();
        } else {
            fechaDeCreacion = format.parse(campos.get("fechaDeCreacion"));
        }
        ticketVista.setFechaDeCreacion(fechaDeCreacion);

        Date fechaDeActualizacion = null;
        if (campos.get("fechaDeActualizacion") != null) {
            if (campos.get("fechaDeActualizacion").equals("ahora")) {
                fechaDeActualizacion = new Date();
            } else {
                fechaDeActualizacion = format.parse(campos.get("fechaDeActualizacion"));
            }
        }
        ticketVista.setFechaDeActualizacion(fechaDeActualizacion);

        return ticketVista;
    }

    @DataTableType
    public TicketVistaActualizar definirTicketVistaActualizar(Map<String, String> campos) {
        TicketVistaActualizar ticketVista = new TicketVistaActualizar();
        ticketVista.setNombre(campos.get("nombre"));
        ticketVista.setDescripcion(campos.get("descripcion"));
        try {
            ticketVista.setResponsableDni(Long.parseLong(campos.get("responsableDni")));
        } catch (NumberFormatException e) {
            ticketVista.setResponsableDni(null);
        }
        ticketVista.setTipo(campos.get("tipo"));
        ticketVista.setSeveridad(campos.get("severidad"));
        ticketVista.setEstado(campos.get("estado"));
        ticketVista.setClienteId(clienteCreado.getId());
        return ticketVista;
    }

    @DataTableType
    public Ticket definirTicket(Map<String, String> campos) throws ParseException {
        Ticket ticket = new Ticket();
        ticket.setNombre(campos.get("nombre"));
        ticket.setDescripcion(campos.get("descripcion"));
        try {
            ticket.setResponsableDni(Long.parseLong(campos.get("responsableDni")));
        } catch (NumberFormatException e) {
            ticket.setResponsableDni(null);
        }
        ticket.setTipo(campos.get("tipo"));
        ticket.setSeveridad(campos.get("severidad"));
        ticket.setEstado(campos.get("estado"));

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ticket.setFechaDeCreacion(format.parse(campos.get("fechaDeCreacion")));
        ticket.setFechaDeActualizacion(format.parse(campos.get("fechaDeActualizacion")));

        return ticket;
    }



    @Entonces("veo que la operación fue {string}")
    public void veoQueLaOperacionFue(String resultado) {
        if (resultado.equals("exitosa")) {
            assertNotNull(ticket);
        } else if (resultado.equals("fallida")) {
            assertNull(ticket);
        } else {
            throw new RuntimeException("Resultado inválido " + resultado);
        }
    }

    @Dado("que existe un ticket con los siguientes atributos:")
    public void queExisteUnTicketConLosSiguientesAtributos(Ticket ticketVista) {
        ticketVista.setCliente(clienteCreado);
        ticketServicio.crear(ticketVista);
    }


    @Cuando("selecciono un ticket con nombre {string}")
    public void seleccionoUnTicketConNombre(String nombre) {
        for (TicketVistaMostrar ticketVista : ticketControlador.listarTickets()) {
            if (ticketVista.getNombre().equals(nombre))
                this.ticket = ticketVista;
        }
    }

    @Cuando("modifico el ticket {string}:")
    public void modificoElTicket(String caso, TicketVistaActualizar ticketVista) {
        if (!validator.validate(ticketVista).isEmpty()) {
            ticket = null;
            return;
        }
        ticketVista.setClienteId(this.ticket.getCliente().getId());
        ticket = ticketControlador.actualizar(this.ticket.getId(), ticketVista);
    }

    @Y("veo que posee el siguiente cliente:")
    public void veoQuePoseeElSiguienteCliente(Cliente clienteVista) {

        Cliente cliente = ticket.getCliente();
        assertEquals(cliente.getNombre(), clienteVista.getNombre());
        assertEquals(cliente.getRazonSocial(), clienteVista.getRazonSocial());
        assertEquals(cliente.getCuit(), clienteVista.getCuit());
        assertEquals(cliente.getFechaDesdeQueEsCliente(), clienteVista.getFechaDesdeQueEsCliente());
        assertEquals(cliente.getEstado(), clienteVista.getEstado());

    }

    @Dado("que existe un cliente con los siguientes atributoss:")
    public void queExisteUnClienteConLosSiguientesAtributoss(Cliente clienteVista) {
        this.clienteCreado = clienteServicio.crear(clienteVista);
    }

    @Cuando("creo un ticket {string} ingresando:")
    public void creoUnTicketIngresando(String caso, TicketVistaCrear ticket) {
        if (!validator.validate(ticket).isEmpty()) {
            this.ticket = null;
            return;
        }
        this.ticket = ticketControlador.crear(ticket);
    }

    @Y("veo que posee los siguientes atributos:")
    public void veoQuePoseeLosSiguientesAtributos(TicketVistaMostrar ticketVista) {
        assertEquals(ticket.getNombre(), ticketVista.getNombre());
        assertEquals(ticket.getDescripcion(), ticketVista.getDescripcion());
        assertEquals(ticket.getEstado(), ticketVista.getEstado());
        assertEquals(ticket.getResponsableDni(), ticketVista.getResponsableDni());
        assertEquals(ticket.getSeveridad(), ticketVista.getSeveridad());
        assertEquals(ticket.getTipo(), ticketVista.getTipo());

        if (ticket.getFechaDeActualizacion() == null
                || ticketVista.getFechaDeActualizacion() == null) {
            assertEquals(ticket.getFechaDeActualizacion(), ticketVista.getFechaDeActualizacion());
        } else {
            assertEquals(DateUtils.truncate(ticket.getFechaDeActualizacion(), Calendar.SECOND),
                    DateUtils.truncate(ticketVista.getFechaDeActualizacion(), Calendar.SECOND));
        }
    }


    @Dado("que existe un producto con nombre {string} y versión {int}")
    public void queExisteUnProductoConNombreYVersión(String arg0, int arg1) {

    }

    @Dado("que soy ingeniero de soporte")
    public void queSoyIngenieroDeSoporte() {
    }
}