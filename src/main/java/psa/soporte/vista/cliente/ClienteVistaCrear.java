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

    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull(message = "La fecha desde la que es cliente es requerida")
    private Date fechaDesdeQueEsCliente;
}
