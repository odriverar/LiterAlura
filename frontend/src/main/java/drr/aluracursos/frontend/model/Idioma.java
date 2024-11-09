package drr.aluracursos.frontend.model;

public class Idioma {
    private final Integer id;
    private final String descripcion;

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
