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
    private String name;
    private String type;
    private String description;
    private String criticality;
    private String owner;
    private String comment;

    public Ticket() {}

    Ticket(String name, String type,String description,String criticality,String owner,String comment) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.criticality = criticality;
        this.owner = owner;
        this.comment = comment;
    }
}