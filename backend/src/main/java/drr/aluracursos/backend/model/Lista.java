package drr.aluracursos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="list")
public class Lista {
    @Id
    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
