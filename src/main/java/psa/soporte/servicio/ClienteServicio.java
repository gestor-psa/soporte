package psa.soporte.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psa.soporte.excepcion.ClienteNoEncontradoExcepcion;
import psa.soporte.modelo.Cliente;
import psa.soporte.repositorio.ClienteRepositorio;

import java.util.Date;
import java.util.List;


@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    public Cliente crear(Cliente nuevoCliente) {
        return repositorio.save(nuevoCliente);
    }

    public Cliente obtener(Long id) throws ClienteNoEncontradoExcepcion {
        return repositorio.findById(id).orElseThrow(() -> new ClienteNoEncontradoExcepcion(id));
    }

    public Cliente actualizar(Long id, Cliente nuevoCliente) {
        return repositorio.findById(id)
                .map(cliente -> {
                    cliente.setNombre(nuevoCliente.getNombre());
                    cliente.setRazonSocial(nuevoCliente.getRazonSocial());
                    cliente.setEstado(nuevoCliente.getEstado());
                    cliente.setCuit(nuevoCliente.getCuit());
                    cliente.getFechaDesdeQueEsCliente(nuevoCliente.getFechaDesdeQueEsCliente());
                    return repositorio.save(cliente);
                })
                .orElseGet(() -> {
                    throw new ClienteNoEncontradoExcepcion(id);
                });
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}