package psa.soporte.modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Ticket {

    private @Id @GeneratedValue Long id;
    private @NonNull String nombre;
    private @NonNull String descripcion;
    private @NonNull String tipo;
    private @NonNull String estado;
    private @NonNull String severidad;
    private String responsable;
    private @NonNull Date fechaDeCreacion;
    private Date fechaDeActualizacion;

    public Ticket() {
        this.estado = "pendiente";
        fechaDeCreacion = new Date();
    }
}