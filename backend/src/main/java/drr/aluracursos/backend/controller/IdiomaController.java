package drr.aluracursos.backend.controller;

import drr.aluracursos.backend.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {
    @Autowired
    private IIdiomaService idiomaService;

    @GetMapping
    public List<String> obtenerIdiomas() {
        return idiomaService.listarIdiomas();
    }
}
