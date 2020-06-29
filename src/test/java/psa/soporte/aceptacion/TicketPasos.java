package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import psa.soporte.PsaApplication;
import psa.soporte.controlador.TicketControlador;
import psa.soporte.modelo.Ticket;
import psa.soporte.servicio.TicketServicio;
import psa.soporte.vista.TicketVistaActualizar;
import psa.soporte.vista.TicketVistaCrear;
import psa.soporte.vista.TicketVistaMostrar;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = PsaApplication.class)
public class TicketPasos {

    @Autowired
    private Validator validator;

    @Autowired
    private TicketControlador ticketControlador;

    @Autowired
    private TicketServicio ticketServicio;

    private TicketVistaMostrar ticket;

    @DataTableType
    public TicketVistaCrear definirTicketVistaCrear(Map<String, String> campos) {
        TicketVistaCrear ticketVista = new TicketVistaCrear();
        ticketVista.setNombre(campos.get("nombre"));
        ticketVista.setDescripcion(campos.get("descripcion"));
        ticketVista.setResponsable(campos.get("responsable"));
        ticketVista.setTipo(campos.get("tipo"));
        ticketVista.setSeveridad(campos.get("severidad"));
        return ticketVista;
    }

    @DataTableType
    public TicketVistaMostrar definirTicketVistaMostrar(Map<String, String> campos) throws ParseException {
        TicketVistaMostrar ticketVista = new TicketVistaMostrar();
        ticketVista.setNombre(campos.get("nombre"));
        ticketVista.setDescripcion(campos.get("descripcion"));
        ticketVista.setResponsable(campos.get("responsable"));
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
        if(campos.get("fechaDeActualizacion") != null ) {
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
        ticketVista.setResponsable(campos.get("responsable"));
        ticketVista.setTipo(campos.get("tipo"));
        ticketVista.setSeveridad(campos.get("severidad"));
        ticketVista.setEstado(campos.get("estado"));
        return ticketVista;
    }

    @DataTableType
    public Ticket definirTicket(Map<String, String> campos) throws ParseException {
        Ticket ticket = new Ticket();
        ticket.setNombre(campos.get("nombre"));
        ticket.setDescripcion(campos.get("descripcion"));
        ticket.setResponsable(campos.get("responsable"));
        ticket.setTipo(campos.get("tipo"));
        ticket.setSeveridad(campos.get("severidad"));
        ticket.setEstado(campos.get("estado"));

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ticket.setFechaDeCreacion(format.parse(campos.get("fechaDeCreacion")));
        ticket.setFechaDeActualizacion(format.parse(campos.get("fechaDeActualizacion")));

        return ticket;
    }

    @Dado("que soy ingeniero de soporte")
    public void queSoyIngenieroDeSoporte() {
    }

    @Dado("que existe un producto con nombre {string} y versión {int}")
    public void queExisteUnProductoConNombreYVersión(String arg0, int arg1) {
    }

    @Y("selecciono la versión {int} del producto {string}")
    public void seleccionoLaVersiónDelProducto(int arg0, String arg1) {
    }

    @Cuando("creo un ticket {string} ingresando:")
    public void creoUnTicketIngresando(String caso, TicketVistaCrear ticket) {
        if (!validator.validate(ticket).isEmpty()) {
            this.ticket = null;
            return;
        }
        this.ticket = ticketControlador.crear(ticket);
    }

    @Entonces("veo que la operación fue {string}")
    public void veoQueLaOperaciónFue(String resultado) {
        if (resultado.equals("exitosa")) {
            assertNotNull(ticket);
        } else if (resultado.equals("fallida")) {
            assertNull(ticket);
        } else {
            throw new RuntimeException("Resultado inválido " + resultado);
        }
    }

    @Y("veo que posee los siguientes atributos:")
    public void veoQuePoseeLosSiguientesAtributos(TicketVistaMostrar ticketVista) {
        assertEquals(ticket.getNombre(), ticketVista.getNombre());
        assertEquals(ticket.getDescripcion(), ticketVista.getDescripcion());
        assertEquals(ticket.getEstado(), ticketVista.getEstado());
        assertEquals(ticket.getResponsable(), ticketVista.getResponsable());
        assertEquals(ticket.getSeveridad(), ticketVista.getSeveridad());
        assertEquals(ticket.getTipo(), ticketVista.getTipo());

        assertTrue(abs(ticket.getFechaDeCreacion().getTime() - ticketVista.getFechaDeCreacion().getTime()) < 1000);

        if (ticket.getFechaDeActualizacion() == null
                || ticketVista.getFechaDeActualizacion() == null) {
            assertEquals(ticket.getFechaDeActualizacion(), ticketVista.getFechaDeActualizacion());
        } else {
            assertTrue(abs(ticket.getFechaDeActualizacion().getTime() - ticketVista.getFechaDeCreacion().getTime()) < 1000);
        }
    }

    @Transactional
    @Y("veo que no posee comentarios")
    public void veoQueNoPoseeComentarios() {
    }

    @Dado("que existe un ticket con los siguientes atributos:")
    public void queExisteUnTicketConLosSiguientesAtributos(Ticket ticket) {
        ticketServicio.crear(ticket);
    }

    @Y("con los siguientes comentarios:")
    public void conLosSiguientesComentarios(DataTable dt) {
    }

    @Cuando("selecciono un ticket con nombre {string}")
    public void seleccionoUnTicketConNombre(String nombre) {
        for (TicketVistaMostrar ticketVista: ticketControlador.listarTickets()) {
            if(ticketVista.getNombre().equals(nombre))
                ticket = ticketVista;
        }
    }

    @Y("veo que posee los siguientes comentarios:")
    public void veoQuePoseeLosSiguientesComentarios(DataTable dt) {
    }

    @Cuando("modifico el ticket {string}:")
    public void modificoElTicket(String caso, TicketVistaActualizar ticketVista) {
        if (!validator.validate(ticketVista).isEmpty()) {
            ticket = null;
            return;
        }
        ticket = ticketControlador.actualizar(ticket.getId(), ticketVista);
    }
}
