package psa.soporte.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Severidad {

    private @Id @GeneratedValue Long id;
    private @NonNull String nombre;

}
