package drr.aluracursos.frontend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import drr.aluracursos.frontend.dto.AutorDTO;
import drr.aluracursos.frontend.dto.IdiomaDTO;
import drr.aluracursos.frontend.dto.LibroDTO;
import drr.aluracursos.frontend.model.Autor;
import drr.aluracursos.frontend.model.Idioma;
import drr.aluracursos.frontend.model.Libro;
import drr.aluracursos.frontend.webclient.ConsumoAPI;
import drr.aluracursos.frontend.webclient.ConvierteDatos;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PrincipalService {
    private final String URL_BASE = "http://localhost:8181/api/";

    private final ConsumoAPI consumo = new ConsumoAPI();
    private final ConvierteDatos convierteDatos = new ConvierteDatos();

    //@Value("${api.url}")

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        String tituloBusca = titulo.trim().replace(" ", "%20");
        var json = consumo.obtenerDatos(URL_BASE + "libros/titulo=" + tituloBusca);
        List<LibroDTO> libros = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        return ConvertirLibroImprimir(libros);
    }

    public List<Libro> buscarLibrosRegistrados() {
        var json = consumo.obtenerDatos(URL_BASE + "libros");
        List<LibroDTO> libros = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        return ConvertirLibroImprimir(libros);
    }

    public List<Autor> listarAutoresRegistrados(){
        var json = consumo.obtenerDatos(URL_BASE + "autores");
        List<AutorDTO> autores = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        return ConvertirAutorImprimir(autores);
    }

    public List<Autor> buscarAutoresVivos(Integer ano) {
        var json = consumo.obtenerDatos(URL_BASE + "autores/anio=" + ano);
        List<AutorDTO> autores = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        return ConvertirAutorImprimir(autores);
    }

    public List<Idioma> listarIdiomas(){
        AtomicInteger contador  = new AtomicInteger(0);
        var json = consumo.obtenerDatos(URL_BASE + "idiomas");
        List<String> idiomas = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        List<Idioma> idiomasEncontrados = idiomas.stream()
                .map(i -> new Idioma(
                        contador.incrementAndGet(),
                        i
                ))
                .collect(Collectors.toList());
        return idiomasEncontrados;
    }

    public List<Libro> buscarLibrosPorIdioma(Idioma idioma) {
        String idiomaBusca = idioma.getDescripcion().split(" - ")[0].trim();
        var json = consumo.obtenerDatos(URL_BASE + "libros/idioma=" + idiomaBusca);
        List<LibroDTO> libros = convierteDatos.convertirDatos(json, new TypeReference<>() {});
        return ConvertirLibroImprimir(libros);
    }

    public List<Libro> ConvertirLibroImprimir(List<LibroDTO> libros) {
        AtomicInteger contador = new AtomicInteger(0);
        return libros.stream()
                .map(l -> {
                    String autoresConcatenados = l.autores().stream()
                            .map(AutorDTO::nombre)
                            .collect(Collectors.joining("; "));
                    String idiomasConcatenados = l.idiomas().stream()
                            .map(IdiomaDTO::descripcion)
                            .collect(Collectors.joining("; "));
                    return new Libro(
                            contador.incrementAndGet(),
                            l.titulo(),
                            autoresConcatenados,
                            idiomasConcatenados,
                            l.descargas()
                    );
                })
                .collect(Collectors.toList());
    }

    public List<Autor> ConvertirAutorImprimir(List<AutorDTO> autores) {
        AtomicInteger contador = new AtomicInteger(0);
        return autores.stream()
                .map(a -> new Autor(
                        contador.incrementAndGet(),
                        a.nombre(),
                        a.anoNacimiento(),
                        a.anoFallecimiento(),
                        a.titulos()
                ))
                .collect(Collectors.toList());
    }
}
