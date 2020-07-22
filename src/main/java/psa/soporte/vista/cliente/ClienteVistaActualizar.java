package psa.soporte.vista.cliente;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

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

    @NotNull(message = "La fecha es requerida, y debe ser en formato yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDesdeQueEsCliente;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "^(activo|inactivo)$", message = "El tipo solo puede ser activo o inactivo")
    private String estado;
}
