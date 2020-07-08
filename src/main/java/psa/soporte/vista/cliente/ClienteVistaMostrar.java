package psa.soporte.vista;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteVistaMostrar {

    private Long Id;
    private String nombre;
    private String razonSocial;
    private String cuit;
    private String estado;
    private Date fechaDesdeQueEsCliente;
}
