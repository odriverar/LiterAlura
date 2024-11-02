package drr.aluracursos.backend.controller;

import drr.aluracursos.backend.dto.LibroDTO;
import drr.aluracursos.backend.service.IIdiomaService;
import drr.aluracursos.backend.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private ILibroService libroService;

    @Autowired
    private IIdiomaService idiomaService;

    @GetMapping()
    public List<LibroDTO> obtenerLibrosRegistrados() {
        return libroService.librosResgitrados();
    }

    @GetMapping("/titulo={titulo}")
    public List<LibroDTO> obtenerLibrosPorTitulo(@PathVariable String titulo){
        return libroService.buscarLibrosPorTitulo(titulo);
    }

    @GetMapping("/idioma={idioma}")
    public List<LibroDTO> obtenerLibrosPorIdioma(@PathVariable String idioma){
        return libroService.buscarLibrosPorIdioma(idioma);
    }
}
