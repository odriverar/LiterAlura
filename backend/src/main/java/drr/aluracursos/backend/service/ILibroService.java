package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.LibroDTO;

import java.util.List;

public interface ILibroService {
    public List<LibroDTO> librosResgitrados();
    public List<LibroDTO> buscarLibrosPorTitulo(String titulo);
    public List<LibroDTO> buscarLibrosPorIdioma(String idioma);
}
