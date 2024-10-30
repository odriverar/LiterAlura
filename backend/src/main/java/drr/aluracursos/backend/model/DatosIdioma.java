package drr.aluracursos.backend.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosIdioma(@JsonAlias("languages") String descripcion) {
}
