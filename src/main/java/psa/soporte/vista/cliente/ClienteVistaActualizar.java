package psa.soporte.vista.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ClienteVistaActualizar {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La Razon Social es requerida")
    private String razonSocial;

    @NotBlank(message = "El cuit es requerido")
    @Pattern(regexp = "^[0-9]{11}$", message = "El cuit debe estar compuesto de 11 numeros")
    private String cuit;

    @NotBlank(message = "La fecha es requerida")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", message = "La fecha debe estar en formato dd/mm/yyyy")
    private String fechaDesdeQueEsCliente;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "^(activo|inactivo)$", message = "El tipo solo puede ser activo o inactivo")
    private String estado;
}
