package drr.aluracursos.frontend.dto;

import java.util.List;

public record LibroDTO(String titulo,
                       List<AutorDTO> autores,
                       List<IdiomaDTO> idiomas,
                       Long descargas) {
}
