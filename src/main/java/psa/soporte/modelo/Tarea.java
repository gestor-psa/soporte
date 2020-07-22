package psa.soporte.modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Tarea {

    private @Id @GeneratedValue Long id;
    private @NonNull String nombre;
    private @NonNull String proyecto;
    private @NonNull String descripcion;
    private @NonNull String estado;
    private @NonNull Date fechaInicio;

    public Tarea(){
        this.estado = "No iniciada";
        this.fechaInicio = new Date();
    }

}
