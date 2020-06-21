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

    @Y("seleccioné una versión de producto")
    public void seleccionéUnaVersiónDeProducto() {
    }

    @Cuando("creo un ticket ingresando:")
    public void creoUnTicketIngresando(DataTable dtTicket) {
    }

    @Entonces("el sistema me informa que la creación del ticket fue {string}")
    public void elSistemaMeInformaQueLaCreaciónDelTicketFue(String arg0) {
    }
}
