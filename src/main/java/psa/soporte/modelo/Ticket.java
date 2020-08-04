package psa.soporte.modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
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
    private @NonNull Date fechaDeCreacion;
    private Date fechaDeActualizacion;
    private Date fechaDeCierre;
    private Long responsableDni;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    public Ticket() {
        this.estado = "pendiente";
        fechaDeCreacion = new Date();
    }

}