package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.TamanosEntity;
import java.util.List;

public interface TamanosRepository extends JpaRepository<TamanosEntity, Integer> {

    @Query("SELECT s FROM TamanosEntity s WHERE s.estado = true")
    List<TamanosEntity> findAllCustom();
}
