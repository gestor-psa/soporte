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

    @Dado("que existe un producto con nombre {string} y versión {int}")
    public void queExisteUnProductoConNombreYVersión(String arg0, int arg1) {
    }

    @Y("selecciono la versión {int} del producto {string}")
    public void seleccionoLaVersiónDelProducto(int arg0, String arg1) {
    }

    @Cuando("creo un ticket {string} ingresando:")
    public void creoUnTicketIngresando(String arg0, DataTable dt) {
    }

    @Entonces("veo que la creación fue {string}")
    public void veoQueLaCreaciónFue(String arg0) {
    }

    @Cuando("creo un ticket ingresando:")
    public void creoUnTicketIngresando(DataTable dt) {
    }

    @Entonces("veo que la operación fue {string}")
    public void veoQueLaOperaciónFue(String arg0) {
    }

    @Y("veo que posee los siguientes atributos:")
    public void veoQuePoseeLosSiguientesAtributos(DataTable dt) {
    }

    @Y("veo que no posee comentarios")
    public void veoQueNoPoseeComentarios() {
    }

    @Dado("que existe un ticket con los siguientes atributos:")
    public void queExisteUnTicketConLosSiguientesAtributos(DataTable dt) {
    }

    @Y("con los siguientes comentarios:")
    public void conLosSiguientesComentarios(DataTable dt) {
    }

    @Cuando("selecciono un ticket con nombre {string}")
    public void seleccionoUnTicketConNombre(String arg0) {
    }

    @Y("veo que posee los siguientes comentarios:")
    public void veoQuePoseeLosSiguientesComentarios(DataTable dt) {
    }

    @Cuando("modifico el ticket {string}:")
    public void modificoElTicket(String arg0, DataTable dt) {
    }
}