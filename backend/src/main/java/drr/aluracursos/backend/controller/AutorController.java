package drr.aluracursos.backend.controller;

import drr.aluracursos.backend.dto.AutorConLibrosDTO;
import drr.aluracursos.backend.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private IAutorService autorService;

    @GetMapping()
    public List<AutorConLibrosDTO> obtenerAutores() {
        return autorService.obtenerAutoresConLibros();
    }

    @GetMapping("/{ano}")
    public List<AutorConLibrosDTO> obtenerAutoresPorAno(@PathVariable Integer ano) {
        return autorService.obtenerAutoresVivosAUnAno(ano);
    }
}
