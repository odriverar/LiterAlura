package drr.aluracursos.backend.repository;

import drr.aluracursos.backend.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String titulo);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Libro l JOIN l.idiomas i WHERE i.descripcion = :idioma")
    List<Libro> findByIdiomas(@Param("idioma") String idioma);
}
