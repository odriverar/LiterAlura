package drr.aluracursos.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import drr.aluracursos.backend.dto.AutorDTO;
import drr.aluracursos.backend.dto.IdiomaDTO;
import drr.aluracursos.backend.dto.LibroDTO;
import drr.aluracursos.backend.dto.RespuestaDTO;
import drr.aluracursos.backend.model.*;
import drr.aluracursos.backend.repository.AutorRepository;
import drr.aluracursos.backend.repository.IdiomaRepository;
import drr.aluracursos.backend.repository.LibroRepository;
import drr.aluracursos.backend.webclient.IConsumoAPI;
import drr.aluracursos.backend.webclient.IConvierteDatos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LibroService implements ILibroService {
    private final IConsumoAPI consumoAPI;
    private final IConvierteDatos convierteDatos;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final IdiomaRepository idiomaRepository;

    /**
     * ! Constructor de las dependencias
     * ? En lugar de usar @Autowired activamos las inyecciones con el constructor.
     * **/
    public LibroService(IConsumoAPI consumoAPI, IConvierteDatos convierteDatos, LibroRepository libroRepository, AutorRepository autorRepository, IdiomaRepository idiomaRepository) {
        this.consumoAPI = consumoAPI;
        this.convierteDatos = convierteDatos;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.idiomaRepository = idiomaRepository;
    }

    @Value("${api.url}")
    private String URL_BASE;

    private List<DatosLibro> getDatosLibro(String tituloLibro) {
        String tituloBuscar = URLEncoder.encode(tituloLibro, StandardCharsets.UTF_8);
        var json = consumoAPI.obtenerDatos(URL_BASE + tituloBuscar);
        RespuestaDTO respuesta = convierteDatos.obtenerDatos(json, new TypeReference<>() {
        });
        return respuesta.resultados();
    }

    /**
     * ! Almacena libro en la base de datos, busqueda por titulo:
     * @param tituloLibro -> Tiutlo del libro o parte del titulo
     * ?void -> Almacenara los libros en la base de datos que coincidadn con el titulo ingresado-
     * */
    private void almacenarLibro(String tituloLibro) {
        List<DatosLibro> datosLibro = getDatosLibro(tituloLibro);
        for (DatosLibro datos : datosLibro) {
            // ! Validamos que el libro no exista en la base de datos
            if(libroRepository.findByTitulo(datos.titulo()).isEmpty()) {
                Libro libro = new Libro();
                libro.setTitulo(datos.titulo());
                libro.setDescargas(datos.descargas());

                // * Trabajamos con Autores
                Set<Autor> autores = new HashSet<>();
                for (DatosAutor datosAutor : datos.autores()) {
                    // ! Validamos la existencia del autor en la base de datos, si no existe guardamos la información en la BD.
                    Autor autor = autorRepository.findByNombre(datosAutor.nombre())
                            .orElseGet(() -> {
                                Autor nuevoAutor = new Autor();
                                nuevoAutor.setNombre(datosAutor.nombre());
                                nuevoAutor.setAnoNacimiento(datosAutor.anoNacimiento());
                                nuevoAutor.setAnoFallecimiento(datosAutor.anoFallecimiento());
                                return autorRepository.save(nuevoAutor);
                            });
                    autores.add(autor);
                }
                libro.setAutores(autores);

                // * Trabajamos con el idioma
                Set<Idioma> idiomas = new HashSet<>();
                for (String codigoIdioma : datos.idiomas()){
                    // ! Recorremos la lista string y validamos la existencia del idioma en la base de datos, si no existe gurdamos la información en la base de datos.
                    Idioma idioma = idiomaRepository.findByDescripcion(codigoIdioma)
                            .orElseGet(() -> {
                                Idioma nuevoIdioma = new Idioma();
                                nuevoIdioma.setDescripcion(codigoIdioma);
                                return idiomaRepository.save(nuevoIdioma);
                            });
                    idiomas.add(idioma);
                }
                libro.setIdiomas(idiomas);

                libroRepository.save(libro);
            }
        }
    }

    /** * Convierte los datos a un formato de salida
     * @param libros -> Lista de libros
     * @return -> Lista de libros registrados, con el formato de presentación.
     * */
    public List<LibroDTO> getConvierteDatos(List<Libro> libros) {
        return libros.stream()
                .map(libro -> new LibroDTO(
                        libro.getTitulo(),
                        libro.getAutores().stream()
                                .map(autor -> new AutorDTO(autor.getNombre(), autor.getAnoNacimiento(), autor.getAnoFallecimiento()))
                                .collect(Collectors.toList()),
                        libro.getIdiomas().stream()
                                .map(idioma -> new IdiomaDTO(idioma.getDescripcion()))
                                .collect(Collectors.toList()),
                        libro.getDescargas()
                ))
                .collect(Collectors.toList());
    }

    /**
    * * Libros resgitrados
    * @return -> Lista de los libros resgitrados.
    **/
    @Override
    public List<LibroDTO> librosResgitrados() {
        return getConvierteDatos(libroRepository.findAll());
    }

    /**
     * Busca libros por el titulo
     * @param titulo, completo o una parte del titulo a buscar
     * @return Una lista de libros que contienen el titulo.
     * */
    @Override
    public List<LibroDTO> buscarLibrosPorTitulo(String titulo) {
        almacenarLibro(titulo);
        return getConvierteDatos(libroRepository.findByTituloContainingIgnoreCase(titulo));
    }

    /**
     * Buscar libros por idioma
     * @param idioma -> Se registra el codigo de idioma ejemplo: en, es, fr
     * @return Una lista de libors que coincidan con el idioma.
     * */
    @Override
    public List<LibroDTO> buscarLibrosPorIdioma(String idioma) {
        return getConvierteDatos(libroRepository.findByIdiomas(idioma));
    }
}
