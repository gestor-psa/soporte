package psa.soporte.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psa.soporte.mapeador.ClienteMapeador;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.vista.ClienteVistaActualizar;
import psa.soporte.vista.ClienteVistaCrear;
import psa.soporte.vista.ClienteVistaMostrar;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private ClienteMapeador mapeador;

    @GetMapping("/clientes")
    public List<ClienteVistaMostrar> listarClientes() {
        return clienteServicio
                .listarClientes()
                .stream()
                .map(cliente -> mapeador.mapear(cliente))
                .collect(Collectors.toList());
    }

    @PostMapping("/clientes")
    public ClienteVistaMostrar crear(@Valid @RequestBody ClienteVistaCrear newCliente) {
        return mapeador.mapear(clienteServicio.crear(mapeador.mapear(newCliente)));
    }

    @GetMapping("/clientes/{id}")
    public CLienteVistaMostrar obtener(@PathVariable Long id) {
        return mapeador.mapear(clienteServicio.obtener(id));
    }

    @PutMapping("/clientes/{id}")
    public ClienteVistaMostrar actualizar(@PathVariable Long id, @Valid @RequestBody ClienteVistaActualizar cliente) {
        return mapeador.mapear(clienteServicio.actualizar(id, mapeador.mapear(cliente)));
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteServicio.eliminar(id);
    }
}