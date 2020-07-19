package psa.soporte.aceptacion;

import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import psa.soporte.controlador.ClienteControlador;
import psa.soporte.modelo.Cliente;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.vista.cliente.ClienteVistaActualizar;
import psa.soporte.vista.cliente.ClienteVistaCrear;
import psa.soporte.vista.cliente.ClienteVistaMostrar;

import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


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
        ClienteVistaCrear clienteVista = new ClienteVistaCrear();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonSocial"));
        clienteVista.setCuit(campos.get("cuit"));
        clienteVista.setFechaDesdeQueEsCliente(campos.get("fechaCliente"));
        return clienteVista;
    }

    @DataTableType
    public ClienteVistaActualizar definirClienteVistaActualizar(Map<String, String> campos) {
        ClienteVistaActualizar clienteVista = new ClienteVistaActualizar();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonSocial"));
        clienteVista.setCuit(campos.get("cuit"));
        clienteVista.setEstado(campos.get("estado"));
        clienteVista.setFechaDesdeQueEsCliente(campos.get("fechaCliente"));
        return clienteVista;
    }

    @DataTableType
    public ClienteVistaMostrar definirClienteVistaMostrar(Map<String, String> campos) throws ParseException {
        ClienteVistaMostrar clienteVista = new ClienteVistaMostrar();
        clienteVista.setNombre(campos.get("nombre"));
        clienteVista.setRazonSocial(campos.get("razonSocial"));
        clienteVista.setCuit(campos.get("cuit"));
        clienteVista.setEstado(campos.get("estado"));
        clienteVista.setFechaDesdeQueEsCliente(campos.get("fechaCliente"));
        return clienteVista;
    }

    @DataTableType
    public Cliente definirCliente(Map<String, String> campos) throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setNombre(campos.get("nombre"));
        cliente.setRazonSocial(campos.get("razonSocial"));
        cliente.setCuit(campos.get("cuit"));
        cliente.setEstado(campos.get("estado"));
        cliente.setFechaDesdeQueEsCliente(campos.get("fechaCliente"));
        return cliente;
    }

    @Cuando("creo un cliente {string} ingresando:")
    public void creoUnClienteIngresando(String caso, ClienteVistaCrear clienteVista) {
        if (!validator.validate(clienteVista).isEmpty()) {
            this.cliente = null;
            return;
        }
        this.cliente = clienteControlador.crear(clienteVista);
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
    public void queExisteUnClienteConLosSiguientesAtributos(Cliente cliente) {
        clienteServicio.crear(cliente);
    }

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
        for (ClienteVistaMostrar clienteVista : clienteControlador.listarClientes()) {
            if (clienteVista.getNombre().equals(nombre))
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
