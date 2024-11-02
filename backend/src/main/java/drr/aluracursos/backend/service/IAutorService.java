package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.AutorConLibrosDTO;

import java.util.List;

public interface IAutorService {
    public List<AutorConLibrosDTO> obtenerAutoresConLibros();
    public List<AutorConLibrosDTO> obtenerAutoresVivosAUnAno(Integer ano);
}
