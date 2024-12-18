package drr.aluracursos.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String descripcion;
    @ManyToMany(mappedBy = "idiomas", fetch = FetchType.EAGER)
    private Set<Libro> libros;

    public Idioma() {}

    public Idioma(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Libro> getLibros() {
        return libros;
    }
}
