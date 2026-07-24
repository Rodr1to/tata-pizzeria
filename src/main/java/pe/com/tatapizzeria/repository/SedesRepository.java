package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.SedesEntity;
import java.util.List;

public interface SedesRepository extends JpaRepository<SedesEntity, Integer> {

    @Query("SELECT s FROM SedesEntity s WHERE s.estado = true")
    List<SedesEntity> findAllCustom();
}
