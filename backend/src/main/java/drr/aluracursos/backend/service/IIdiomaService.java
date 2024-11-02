package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.IdiomaConLibrosDTO;

import java.util.List;

public interface IIdiomaService {
    List<IdiomaConLibrosDTO> buscarIdiomaConLibros(String idiomaBusca);
    List<String> listarIdiomas();
}
