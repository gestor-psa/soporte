package psa.soporte.vista.ticket;

import lombok.Getter;
import lombok.Setter;
import psa.soporte.modelo.Cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TicketVistaActualizar {

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La descripción es requerida")
    private String descripcion;

    @NotBlank(message = "El tipo es requerido")
    @Pattern(regexp = "^(consulta|mejora|incidencia)$",
            message = "El tipo solo puede ser consulta, mejora o incidencia")
    private String tipo;

    @NotBlank(message = "La severidad es requerida")
    @Pattern(regexp = "^(alta|media|baja)$",
            message = "La severidad solo puede ser alta, media o baja")
    private String severidad;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "^(pendiente|iniciado|cerrado)$",
            message = "El estado solo puede ser pendiente, iniciado o cerrado")
    private String estado;

    private Long responsableDni;

    private Cliente cliente;
}
