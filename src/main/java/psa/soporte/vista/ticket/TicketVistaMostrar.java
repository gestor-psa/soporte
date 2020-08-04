package psa.soporte.vista.ticket;

import lombok.Getter;
import lombok.Setter;
import psa.soporte.modelo.Cliente;
import psa.soporte.modelo.Ticket;

import java.util.Date;

@Getter
@Setter
public class TicketVistaMostrar implements Comparable<TicketVistaMostrar> {

    private Long Id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String severidad;
    private String estado;
    private Date fechaDeCreacion;
    private Date fechaDeActualizacion;
    private Date fechaDeCierre;
    private Long responsableDni;
    private Cliente cliente;

    @Override
    public int compareTo(TicketVistaMostrar otroTicket) {
        return this.fechaDeCreacion.compareTo(otroTicket.getFechaDeCreacion());
    }

}
