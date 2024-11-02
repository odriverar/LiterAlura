package drr.aluracursos.backend.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title") String titulo,
                         @JsonAlias("download_count") Long descargas,
                         @JsonAlias("authors") List<DatosAutor> autores,
                         @JsonAlias("languages") List<String> idiomas) {
}
