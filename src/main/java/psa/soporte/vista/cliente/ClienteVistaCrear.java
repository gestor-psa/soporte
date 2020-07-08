package psa.soporte.vista;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteVistaCrear {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La Razon Social es requerida")
    private String razonSocial;

    @NotBlank(message = "El cuit es requerido")
    @Size(min = 11, max = 11, message
            = "El cuit debe tener 11 digitos")
    @Pattern(regexp = "^[0-9]",
            message = "El cuit debe tener 11 digitos")
    private String cuit;

    @NotBlank(message = "La fecha desde la que es cliente es requerida")
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",
            message = "El formato de la fecha debe ser dd/mm/yyyy")
    private Date fechaDesdeQueEsCliente;
}
