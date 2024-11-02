package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.IdiomaConLibrosDTO;

import java.util.List;

public interface IIdiomaService {
    public List<IdiomaConLibrosDTO> buscarIdiomaConLibros(String idiomaBusca);
    public List<String> listarIdiomas();
}
