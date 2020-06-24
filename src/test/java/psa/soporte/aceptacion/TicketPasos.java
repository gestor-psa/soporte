package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class TicketPasos {
    @Dado("que soy ingeniero de soporte")
    public void queSoyIngenieroDeSoporte() {
    }

    @Y("seleccioné la versión {int} del producto {string}")
    public void seleccionéUnaVersiónDelProducto(int version, String producto) {
    }

    @Cuando("creo un ticket ingresando:")
    public void creoUnTicketIngresando(DataTable dtTicket) {
    }

    @Entonces("el sistema me informa que la creación del ticket fue {string}")
    public void elSistemaMeInformaQueLaCreaciónDelTicketFue(String arg0) {
    }

    @Y("que se creó con los siguientes atributos:")
    public void queSeCreóConLosSiguientesAtributos() {
    }

    @Y("sin comentarios")
    public void sinComentarios() {
    }

    @Dado("que existe un ticket con los siguientes atributos:")
    public void queExisteUnTicketConLosSiguientesAtributos(DataTable dtTicket) {
    }

    @Y("con los siguientes comentarios:")
    public void conLosSiguientesComentarios(DataTable dtComentarios) {
    }

    @Cuando("selecciono un ticket con nombre {string}")
    public void seleccionoUnTicketConNombre(String arg0) {
    }

    @Entonces("el sistema me informa que dicho ticket posee los siguientes atributos:")
    public void elSistemaMeInformaQueDichoTicketTiene(DataTable dtTicket) {
    }

    @Y("los siguientes comentarios:")
    public void losSiguientesComentarios(DataTable dtComentarios) {
    }
}
