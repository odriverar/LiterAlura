package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.IdiomaConLibrosDTO;
import drr.aluracursos.backend.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService implements IIdiomaService {
    @Autowired
    private IdiomaRepository idiomaRepository;

    @Override
    public List<IdiomaConLibrosDTO> buscarIdiomaConLibros(String idiomaBusca) {
        return List.of();
    }

    @Override
    public List<String> listarIdiomas() {
        return idiomaRepository.obtenerIdiomas();
    }
}
