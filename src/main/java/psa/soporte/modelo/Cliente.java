package psa.soporte.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Cliente {

    private @Id @GeneratedValue Long id;
    private String nombre;
    private String razonSocial;
    private String cuit;
    private Date fechaDesdeQueEsCliente;

    public Cliente(){
        this.fechaDesdeQueEsCliente = Calendar.getInstance().getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Date getFechaDesdeQueEsCliente() {
        return fechaDesdeQueEsCliente;
    }

    public void setFechaDesdeQueEsCliente(Date fechaDesdeQueEsCliente) {
        this.fechaDesdeQueEsCliente = fechaDesdeQueEsCliente;
    }
}
