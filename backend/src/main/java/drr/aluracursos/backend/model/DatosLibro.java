package drr.aluracursos.backend.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosLibro(@JsonAlias("title") String titulo,
                         @JsonAlias("download_count") Long descargas) {
}
