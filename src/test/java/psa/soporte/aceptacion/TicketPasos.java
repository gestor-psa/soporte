package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import psa.soporte.PsaApplication;
import psa.soporte.controller.TicketController;
import psa.soporte.model.Comentario;
import psa.soporte.model.Ticket;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext
@ContextConfiguration(classes = PsaApplication.class)
public class TicketPasos {

    @Autowired
    public TicketController ticketController;
    public Ticket createdTicket;
    public Ticket modifiedTicket;
    public Ticket selectedTicket;
    public Long ticketId;

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
    public void creoUnTicketIngresando(String arg0, DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = new Ticket();
        newTicket.setId(1L);
        newTicket.setNombre(ticketData.get(1).get(0));
        newTicket.setDescripcion(ticketData.get(1).get(1));
        newTicket.setResponsable(ticketData.get(1).get(2));
        newTicket.setTipo(ticketData.get(1).get(3));
        newTicket.setSeveridad(ticketData.get(1).get(4));
        ticketId = newTicket.getId();
        createdTicket = ticketController.newTicket(newTicket);
    }

    @Entonces("veo que la creación fue {string}")
    public void veoQueLaCreaciónFue(String arg0) {
        if (arg0 == "exitosa"){
            assertNotNull(createdTicket);
        }
        else if (arg0 == "fallida"){
            assertNull(createdTicket);
        }
    }

    @Cuando("creo un ticket ingresando:")
    public void creoUnTicketIngresando(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = new Ticket();
        newTicket.setId(1L);
        newTicket.setNombre(ticketData.get(1).get(0));
        newTicket.setDescripcion(ticketData.get(1).get(1));
        newTicket.setResponsable(ticketData.get(1).get(2));
        newTicket.setTipo(ticketData.get(1).get(3));
        newTicket.setSeveridad(ticketData.get(1).get(4));
        ticketId = newTicket.getId();
        createdTicket = ticketController.newTicket(newTicket);
    }

    @Entonces("veo que la operación fue {string}")
    public void veoQueLaOperaciónFue(String arg0) {
        if (arg0 == "exitosa"){
            assertNotNull(modifiedTicket);
        }
        else if (arg0 == "fallida"){
            assertNull(modifiedTicket);
        }
    }

    @Y("veo que posee los siguientes atributos:")
    public void veoQuePoseeLosSiguientesAtributos(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = ticketController.one(ticketId);
        assertEquals(ticketData.get(1).get(0),newTicket.getNombre());
        assertEquals(ticketData.get(1).get(1),newTicket.getDescripcion());
        assertEquals(ticketData.get(1).get(2),newTicket.getResponsable());
        assertEquals(ticketData.get(1).get(3),newTicket.getTipo());
        assertEquals(ticketData.get(1).get(4),newTicket.getSeveridad());
    }

    @Transactional
    @Y("veo que no posee comentarios")
    public void veoQueNoPoseeComentarios() {
        assertTrue(ticketController.one(ticketId).getComentarios().isEmpty());
    }

    @Dado("que existe un ticket con los siguientes atributos:")
    public void queExisteUnTicketConLosSiguientesAtributos(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = new Ticket();
        newTicket.setId(1L);
        newTicket.setNombre(ticketData.get(1).get(0));
        newTicket.setDescripcion(ticketData.get(1).get(1));
        newTicket.setResponsable(ticketData.get(1).get(2));
        newTicket.setTipo(ticketData.get(1).get(3));
        newTicket.setSeveridad(ticketData.get(1).get(4));
        newTicket.setEstado(ticketData.get(1).get(5));
        //newTicket.setFechaCreacion(ticketData.get(1).get(6));
        //newTicket.setFechaCreacion(ticketData.get(1).get(7));
        ticketId = newTicket.getId();
        createdTicket = ticketController.newTicket(newTicket);

    }

    @Y("con los siguientes comentarios:")
    public void conLosSiguientesComentarios(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        for (int i = 0; i < ticketData.size() - 1; i++) {
            Comentario nuevoComentario = new Comentario();
            nuevoComentario.setComentario(ticketData.get(i+1).get(0));
            nuevoComentario.setUsuario(ticketData.get(i+1).get(1));
            //nuevoComentario.setFechaComentario(ticketData.get(i+1).get(2));
            createdTicket.agregarComentario(nuevoComentario);
        }
    }

    @Cuando("selecciono un ticket con nombre {string}")
    public void seleccionoUnTicketConNombre(String arg0) {
        List<Ticket> tickets = ticketController.all();
        for (int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).getNombre().equals(arg0)){
                selectedTicket = tickets.get(i);
                System.out.println("se guarda el ticket seleccionado");
            }
        }
    }

    @Y("veo que posee los siguientes comentarios:")
    public void veoQuePoseeLosSiguientesComentarios(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        List<Comentario> comentarios = createdTicket.getComentarios();
        for (int i = 0; i < comentarios.size(); i++) {
            assertEquals(comentarios.get(i).getComentario(),ticketData.get(i+1).get(0));
            assertEquals(comentarios.get(i).getUsuario(),ticketData.get(i+1).get(1));
            //assertEquals(comentarios.get(i).getFechaComentario(),ticketData.get(i+1).get(2));
        }
    }

    @Cuando("modifico el ticket {string}:")
    public void modificoElTicket(String arg0, DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = ticketController.one(ticketId);
        newTicket.setNombre(ticketData.get(1).get(0));
        newTicket.setDescripcion(ticketData.get(1).get(1));
        newTicket.setResponsable(ticketData.get(1).get(2));
        newTicket.setTipo(ticketData.get(1).get(3));
        newTicket.setSeveridad(ticketData.get(1).get(4));
        newTicket.setEstado(ticketData.get(1).get(5));
        modifiedTicket = ticketController.replaceTicket(newTicket,ticketId);
    }

    @Entonces("veo que el ticket seleccionado posee los siguientes atributos:")
    public void veoQueElTicketSeleccionadoPoseeLosSiguientesAtributos(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        Ticket newTicket = selectedTicket;
        assertEquals(ticketData.get(1).get(0),newTicket.getNombre());
        assertEquals(ticketData.get(1).get(1),newTicket.getDescripcion());
        assertEquals(ticketData.get(1).get(2),newTicket.getResponsable());
        assertEquals(ticketData.get(1).get(3),newTicket.getTipo());
        assertEquals(ticketData.get(1).get(4),newTicket.getSeveridad());
    }

    @Transactional
    @Y("veo que el ticket seleccionado posee los siguientes comentarios:")
    public void veoQueElTicketSeleccionadoPoseeLosSiguientesComentarios(DataTable dt) {
        List<List<String>> ticketData = dt.asLists();
        List<Comentario> comentarios = selectedTicket.getComentarios();
        for (int i = 0; i < comentarios.size(); i++) {
            assertEquals(comentarios.get(i).getComentario(), ticketData.get(i + 1).get(0));
            assertEquals(comentarios.get(i).getUsuario(), ticketData.get(i + 1).get(1));
            //assertEquals(comentarios.get(i).getFechaComentario(),ticketData.get(i+1).get(2));
        }
    }
}
