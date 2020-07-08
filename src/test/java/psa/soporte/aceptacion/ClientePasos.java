package psa.soporte.aceptacion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import psa.soporte.PsaApplication;
import psa.soporte.controlador.ClienteControlador;
import psa.soporte.modelo.Cliente;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.vista.ClienteVistaActualizar;
import psa.soporte.vista.ClienteVistaCrear;
import psa.soporte.vista.ClienteVistaMostrar;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


@ContextConfiguration(classes = PsaApplication.class)
public class ClientePasos {

    @Autowired
    private Validator validator;


    @Autowired
    private ClienteControlador clienteControlador;

    @Autowired
    private ClienteServicio clienteServicio;

    private ClienteVistaMostrar cliente;

    @DataTableType
    public ClienteVistaCrear definirClienteVistaCrear(Map<String, String> campos) {
        CLienteVistaCrear clienteVista = new ClienteVistaCrear();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonsocial"));
        clienteVista.setCuit(campos.get("cuit"));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        clienteVista.setFechaDesdeQueEsCliente(format.parse(campos.get("fechacliente")));
        return clienteVista;
    }

    @DataTableType
    public ClienteVistaMostrar definirClienteVistaMostrar(Map<String, String> campos) throws ParseException {
        ClienteVistaMostrar clienteVista = new ClienteVistaMostrar();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonsocial"));
        clienteVista.setCuit(campos.get("cuit"));
        clienteVista.setEstado(campos.get("estado"));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        clienteVista.setFechaDesdeQueEsCliente(format.parse(campos.get("fechacliente")));
        return clienteVista;
    }

    @DataTableType
    public ClienteVistaActualizar definirCLienteVistaActualizar(Map<String, String> campos) {
        ClienteVistaActualizar clienteVista = new ClienteVistaActualizar();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonsocial"));
        clienteVista.setCuit(campos.get("cuit"));
        clienteVista.setEstado(campos.get("estado"));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        clienteVista.setFechaDesdeQueEsCliente(format.parse(campos.get("fechacliente")));
        return clienteVista;
    }

    @DataTableType
    public Cliente definirCliente(Map<String, String> campos) throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setNombre(campos.get("nombre"));
        cliente.setRazonSocial(campos.get("razonsocial"));
        cliente.setCuit(campos.get("cuit"));
        cliente.setEstado(campos.get("estado"));
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        cliente.setFechaDesdeQueEsCliente(format.parse(campos.get("fechacliente")));
        return cliente;
    }



    @Dado("que soy ingeniero de soporte")
    public void queSoyIngenieroDeSoporte() {
    }

    @Cuando("creo un cliente {string} ingresando:")
    public void creoUnClienteIngresando(String caso, ClienteVistaCrear cliente) {
        if (!validator.validate(cliente).isEmpty()) {
            this.cliente = null;
            return;
        }
        this.cliente = clienteControlador.crear(cliente);
    }

    @Entonces("veo que el cliente posee los siguientes atributos:")
    public void veoQueElClientePoseeLosSiguientesAtributos(ClienteVistaMostrar clienteVista) {
        assertEquals(cliente.getNombre(), clienteVista.getNombre());
        assertEquals(cliente.getCuit(), clienteVista.getCuit());
        assertEquals(cliente.getRazonSocial(), clienteVista.getRazonSocial());
        assertEquals(cliente.getEstado(), clienteVista.getEstado());
        assertEquals(cliente.getFechaDesdeQueEsCliente(), clienteVista.getFechaDesdeQueEsCliente());
    }

    @Dado("que existe un cliente con los siguientes atributos:")
    public void queExisteUnClienteConLosSiguientesAtributos(Cliente cliente) { clienteServicio.crear(cliente); }

    @Cuando("modifico el cliente {string}:")
    public void modificoElCliente(String caso, ClienteVistaActualizar clienteVista) {
        if (!validator.validate(clienteVista).isEmpty()) {
            cliente = null;
            return;
        }
        cliente = clienteControlador.actualizar(cliente.getId(), clienteVista);
    }

    @Y("selecciono un cliente con nombre {string}")
    public void seleccionoUnClienteConNombre(String nombre) {
        for (ClienteVistaMostrar clienteVista: clienteControlador.listarClientes()) {
            if(clienteVista.getNombre().equals(nombre))
                cliente = clienteVista;
        }
    }

    @Entonces("veo que la operación de cliente fue {string}")
    public void veoQueLaOperacionDeClienteFue(String resultado) {
        if (resultado.equals("exitosa")) {
            assertNotNull(cliente);
        } else if (resultado.equals("fallida")) {
            assertNull(cliente);
        } else {
            throw new RuntimeException("Resultado inválido " + resultado);
        }
    }
}
