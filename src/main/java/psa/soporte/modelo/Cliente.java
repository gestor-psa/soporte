package psa.soporte.modelo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Cliente {

    private @Id @GeneratedValue Long id;
    private @NonNull String nombre;
    private @NonNull String razonSocial;
    private @NonNull String cuit;
    private @NonNull Date fechaDesdeQueEsCliente;
    private @NonNull String estado;

    public Cliente(){
        this.estado="activo";
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
