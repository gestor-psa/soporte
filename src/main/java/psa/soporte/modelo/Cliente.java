package psa.soporte.modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Cliente {

    private @Id @GeneratedValue Long id;
    private @NonNull String nombre;
    private @NonNull String razonSocial;
    private @NonNull String cuit;
    private @NonNull LocalDate fechaDesdeQueEsCliente;
    private @NonNull String estado;

    public Cliente() {
        this.estado = "activo";
    }
}
