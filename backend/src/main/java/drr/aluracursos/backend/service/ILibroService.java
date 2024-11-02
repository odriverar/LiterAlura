package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.LibroDTO;

import java.util.List;

public interface ILibroService {
    List<LibroDTO> librosResgitrados();
    List<LibroDTO> buscarLibrosPorTitulo(String titulo);
    List<LibroDTO> buscarLibrosPorIdioma(String idioma);
}
