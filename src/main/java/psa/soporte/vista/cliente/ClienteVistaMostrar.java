package psa.soporte.vista.cliente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteVistaMostrar {

    private Long Id;
    private String nombre;
    private String razonSocial;
    private String cuit;
    private String estado;
    private LocalDate fechaDesdeQueEsCliente;

}
