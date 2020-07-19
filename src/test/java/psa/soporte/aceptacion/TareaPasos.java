package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import psa.soporte.modelo.Ticket;

public class TareaPasos {

    /*@Autowired
    private TareaServicio tareaServicio;

    @Autowired
    private TareaControlador tareaControlador;*/

    private Ticket ticket;

    @Dado("que existe un ticket:")
    public void queExisteUnTicket() {
    }

    @Cuando("selecciono un ticket y listo sus tareas:")
    public void seleccionoUnTicketYListoSusTareas() {
    }

    @Cuando("creo una tarea {string} ingresando:")
    public void creoUnaTareaIngresando(String arg0, DataTable dt) {
    }

    @Entonces("veo que la operacion de creacion de tarea fue {string}")
    public void veoQueLaOperacionDeCreacionDeTareaFue(String arg0) {
    }

    @Y("que tiene tareas creadas con los siguientes atributos:")
    public void queTieneTareasCreadasConLosSiguientesAtributos(DataTable dt) {
    }

    @Entonces("obtengo una lista de tareas con los siguientes atributos:")
    public void obtengoUnaListaDeTareasConLosSiguientesAtributos(DataTable dt) {
    }
}
