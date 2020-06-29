package psa.soporte.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psa.soporte.mapeador.TicketMapeador;
import psa.soporte.servicio.TicketServicio;
import psa.soporte.vista.TicketVistaActualizar;
import psa.soporte.vista.TicketVistaCrear;
import psa.soporte.vista.TicketVistaMostrar;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TicketControlador {

    @Autowired
    private TicketServicio ticketServicio;

    @Autowired
    private TicketMapeador mapeador;

    @GetMapping("/tickets")
    public List<TicketVistaMostrar> listarTickets() {
        return ticketServicio
                .listarTickets()
                .stream()
                .map(ticket -> mapeador.mapear(ticket))
                .collect(Collectors.toList());
    }

    @PostMapping("/tickets")
    public TicketVistaMostrar crear(@Valid @RequestBody TicketVistaCrear newTicket) {
        return mapeador.mapear(ticketServicio.crear(mapeador.mapear(newTicket)));
    }

    @GetMapping("/tickets/{id}")
    public TicketVistaMostrar obtener(@PathVariable Long id) {
        return mapeador.mapear(ticketServicio.obtener(id));
    }

    @PutMapping("/tickets/{id}")
    public TicketVistaMostrar actualizar(@PathVariable Long id, @Valid @RequestBody TicketVistaActualizar ticket) {
        return mapeador.mapear(ticketServicio.actualizar(id, mapeador.mapear(ticket)));
    }

    @DeleteMapping("/tickets/{id}")
    public void eliminar(@PathVariable Long id) {
        ticketServicio.eliminar(id);
    }
}