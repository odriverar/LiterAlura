package drr.aluracursos.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_idioma",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id")
    )
    private Set<Idioma> idiomas;
    private Long descargas;

    public Libro() {}

    public Libro(String titulo, Long descargas) {
        this.titulo = titulo;
        this.descargas = descargas;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public Set<Idioma> getIdiomas() {
        return idiomas;
    }

    public Long getDescargas() {
        return descargas;
    }
}
