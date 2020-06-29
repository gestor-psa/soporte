package psa.soporte.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Comentario {

    private @Id @GeneratedValue @NonNull Long id;
    private @NonNull String contenido;
    private @NonNull Date fechaDeCreacion;

    public Comentario(String comentario) {
        this.fechaDeCreacion = new Date();
        this.contenido = comentario;
    }
}
