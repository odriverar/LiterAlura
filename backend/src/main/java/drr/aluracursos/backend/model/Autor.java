package drr.aluracursos.backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String nombre;
    private Integer anoNacimiento;
    private Integer anoFallecimiento;
    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private Set<Libro> libros;

    public Autor() {}

    public Autor(String nombre, Integer anoNacimiento, Integer anoFallecimiento) {
        this.nombre = nombre;
        this.anoNacimiento = anoNacimiento;
        this.anoFallecimiento = anoFallecimiento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public Integer getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public Set<Libro> getLibros() {
        return libros;
    }
}
