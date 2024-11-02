package drr.aluracursos.backend.repository;

import drr.aluracursos.backend.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros")
    List<Autor> buscarAutoresConLibros();

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE a.anoFallecimiento <= :ano")
    List<Autor> buscarAutoresConAnoFallecimiento(Integer ano);
}
