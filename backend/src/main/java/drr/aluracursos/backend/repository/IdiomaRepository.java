package drr.aluracursos.backend.repository;

import drr.aluracursos.backend.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
    Optional<Idioma> findByDescripcion(String descripcion);

    //@Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE a.anoFallecimiento <= :ano")
    @Query("SELECT i FROM Idioma i LEFT JOIN FETCH i.libros JOIN Lista l on l.id = i.descripcion WHERE i.descripcion = :idiomaBusca")
    List<Idioma> obtenerIdiomaConLibros(String idiomaBusca);

    @Query("SELECT CONCAT(i.descripcion, ' - ', l.value) FROM Idioma i JOIN Lista l ON l.id = i.descripcion ORDER BY i.descripcion")
    List<String> obtenerIdiomas();
}
