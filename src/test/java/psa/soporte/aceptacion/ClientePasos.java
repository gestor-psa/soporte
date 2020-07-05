package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;


//@ContextConfiguration(classes = PsaApplication.class)
public class ClientePasos {

    @Autowired
    private Validator validator;

    /*
    @Autowired
    private ClienteControlador ticketControlador;

    @Autowired
    private ClienteServicio ticketServicio;

    private ClienteVistaMostrar ticket;

    @DataTableType
    public TicketVistaCrear definirTicketVistaCrear(Map<String, String> campos) {
        ClienteVistaCrear clienteVista = new ClienteVistaCrear();
        //setup de ClienteVistaCrear
        return clienteVista;
    }

    @DataTableType
    public TicketVistaMostrar definirTicketVistaMostrar(Map<String, String> campos) throws ParseException {
        TicketVistaMostrar clienteVista = new ClienteVistaMostrar();
        //setup de ClienteVistaMostrar
        return clienteVista;
    }

    @DataTableType
    public ClienteVistaActualizar definirTicketVistaActualizar(Map<String, String> campos) {
        ClienteVistaActualizar clienteVista = new ClienteVistaActualizar();
        //setup de ClienteVistaActualizar
        return clienteVista;
    }

    @DataTableType
    public Cliente definirCliente(Map<String, String> campos) throws ParseException {
        Cliente cliente = new Cliente();
        //setup cliente
        return cliente;
    }



    @Dado("que soy ingeniero de soporte")
    public void queSoyIngenieroDeSoporte() {
    }
    */

    @Cuando("creo un cliente {string} ingresando:")
    public void creoUnClienteIngresando(String arg0,DataTable dt) {
    }

    @Entonces("veo que el cliente posee los siguientes atributos:")
    public void veoQueElClientePoseeLosSiguientesAtributos(DataTable dt) {
    }

    @Dado("que existe un cliente con los siguientes atributos:")
    public void queExisteUnClienteConLosSiguientesAtributos(DataTable dt) {
    }

    @Cuando("modifico el cliente {string}:")
    public void modificoElCliente(String arg0,DataTable dt) {
    }

    @Y("selecciono un cliente con nombre {string}")
    public void seleccionoUnClienteConNombre(String arg0) {
    }

    @Entonces("veo que la operación de cliente fue {string}")
    public void veoQueLaOperacionDeClienteFue(String arg0) {
    }
}
