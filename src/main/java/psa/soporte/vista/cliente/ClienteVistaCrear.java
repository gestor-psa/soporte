package psa.soporte.vista.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class ClienteVistaCrear {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La Razon Social es requerida")
    private String razonSocial;

    @NotBlank(message = "El cuit es requerido")
    @Pattern(regexp = "^[0-9]{11}$", message = "El cuit debe estar compuesto de 11 numeros")
    private String cuit;

    //@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$", message = "El formato de la fecha debe ser dd/mm/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date fechaDesdeQueEsCliente;
}
