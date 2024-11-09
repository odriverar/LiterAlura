package drr.aluracursos.frontend.model;

public class Libro {
    private int id;
    private String titulo;
    private String autores;
    private String idiomas;
    private Long descargas;

    public Libro(int id, String titulo, String autores, String idiomas, Long descargas) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.descargas = descargas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public Long getDescargas() {
        return descargas;
    }

    @Override
    public String toString() {
        return "--------------------------------------- LIBRO " + getId() + " ---------------------------------------" +
               "\nTítulo: " + getTitulo() +
               "\nAutor(es): " + getAutores() +
               "\nIdioma: " + getIdiomas() +
               "\nDescargas: " + getDescargas() +
               "\n----------------------------------------------------------------------------------------";
    }
}
