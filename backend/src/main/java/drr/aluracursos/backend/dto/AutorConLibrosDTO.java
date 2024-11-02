package drr.aluracursos.backend.dto;

import java.util.List;

public record AutorConLibrosDTO(String nombre,
                                Integer anoNacimiento,
                                Integer anoFallecimiento,
                                String titulos) {
}
