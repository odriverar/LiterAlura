package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.AutorConLibrosDTO;

import java.util.List;

public interface IAutorService {
    List<AutorConLibrosDTO> obtenerAutoresConLibros();
    List<AutorConLibrosDTO> obtenerAutoresVivosAUnAno(Integer ano);
}
