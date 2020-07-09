package psa.soporte.mapeador;

import org.springframework.stereotype.Component;
import psa.soporte.modelo.Cliente;
import psa.soporte.vista.cliente.ClienteVistaActualizar;
import psa.soporte.vista.cliente.ClienteVistaCrear;
import psa.soporte.vista.cliente.ClienteVistaMostrar;

@Component
public class ClienteMapeador {

    public Cliente mapear(ClienteVistaCrear clienteVista) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteVista.getNombre());
        cliente.setRazonSocial(clienteVista.getRazonSocial());
        cliente.setCuit(clienteVista.getCuit());
        cliente.setFechaDesdeQueEsCliente(clienteVista.getFechaDesdeQueEsCliente());
        return cliente;
    }

    public Cliente mapear(ClienteVistaActualizar clienteVista) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteVista.getNombre());
        cliente.setRazonSocial(clienteVista.getRazonSocial());
        cliente.setCuit(clienteVista.getCuit());
        cliente.setFechaDesdeQueEsCliente(clienteVista.getFechaDesdeQueEsCliente());
        cliente.setEstado(clienteVista.getEstado());
        return cliente;
    }

    public ClienteVistaMostrar mapear(Cliente clienteVista) {
        ClienteVistaMostrar cliente = new ClienteVistaMostrar();
        cliente.setId(clienteVista.getId());
        cliente.setNombre(clienteVista.getNombre());
        cliente.setRazonSocial(clienteVista.getRazonSocial());
        cliente.setCuit(clienteVista.getCuit());
        cliente.setFechaDesdeQueEsCliente(clienteVista.getFechaDesdeQueEsCliente());
        cliente.setEstado(clienteVista.getEstado());
        return cliente;
    }
}
