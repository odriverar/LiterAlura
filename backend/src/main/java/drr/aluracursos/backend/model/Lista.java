package drr.aluracursos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="list")
public class Lista {
    @Id
    private String id;
    private String value;
}
