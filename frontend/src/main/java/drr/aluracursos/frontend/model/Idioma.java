package drr.aluracursos.frontend.model;

public class Idioma {
    private Integer id;
    private String descripcion;

    public Idioma(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + descripcion;
    }
}
