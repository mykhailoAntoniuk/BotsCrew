package test.botscrew.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import test.botscrew.model.Lector;

import java.util.List;

public interface LectorRepository extends CrudRepository<Lector, Long> {
    @Query("select l from Lector l where l.firstname LIKE concat(concat('%', :template), '%') OR l.lastname LIKE concat(concat('%', :template), '%')")
    List<Lector> findAllByTemplate(String template);
}
