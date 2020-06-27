package psa.soporte.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public
class Ticket {

    private @Id @GeneratedValue Long id;
    private String nombre;
    private String tipo;
    private String estado;
    private String descripcion;
    private String severidad;
    private String responsable;
    private String comentario;
    private String cliente;

    public Ticket() {}

    Ticket(String nombre, String tipo, String estado,String descripcion,String severidad,String responsable,String comentario, String cliente) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.responsable = responsable;
        this.comentario = comentario;
        this.cliente= cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String nombre) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}