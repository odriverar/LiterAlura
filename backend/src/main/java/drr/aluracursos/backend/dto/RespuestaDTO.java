package drr.aluracursos.backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import drr.aluracursos.backend.model.DatosLibro;

import java.util.List;

public record RespuestaDTO(int count,
                           String next,
                           String previous,
                           @JsonAlias("results") List<DatosLibro> resultados) {
}
