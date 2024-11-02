package drr.aluracursos.backend.service;

import drr.aluracursos.backend.dto.AutorConLibrosDTO;
import drr.aluracursos.backend.model.Autor;
import drr.aluracursos.backend.model.Libro;
import drr.aluracursos.backend.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService implements IAutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorConLibrosDTO> obtenerAutoresConLibros() {
        return getBuscarAutorConLibro(autorRepository.buscarAutoresConLibros());
    }

    @Override
    public List<AutorConLibrosDTO> obtenerAutoresVivosAUnAno(Integer ano) {
        return getBuscarAutorConLibro(autorRepository.buscarAutoresConAnoFallecimiento(ano));
    }

    /**
     * Convierte datos a un formato de salida, en este caso concatena los titulos a un string
     * @param autores -> Lista del modelo Autor
     * @return -> retorna información con el formato de salida del modelo AutorConLibrosDTO
     * */
    public List<AutorConLibrosDTO> getBuscarAutorConLibro(List<Autor> autores){
        return autores.stream()
                .map(a -> {
                    String titulosConcatenados = a.getLibros().stream()
                            .map(Libro::getTitulo)
                            .collect(Collectors.joining("; "));

                    return new AutorConLibrosDTO(
                            a.getNombre(),
                            a.getAnoNacimiento(),
                            a.getAnoFallecimiento(),
                            titulosConcatenados
                    );
                })
                .collect(Collectors.toList());
    }
}
