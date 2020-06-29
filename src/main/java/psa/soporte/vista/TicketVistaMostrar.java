package psa.soporte.vista;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketVistaMostrar {

    private Long Id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String severidad;
    private String responsable;
    private String estado;
    private Date fechaDeCreacion;
    private Date fechaDeActualizacion;
}
