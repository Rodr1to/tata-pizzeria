package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.RepartidoresEntity;
import java.util.List;

public interface RepartidoresRepository extends JpaRepository<RepartidoresEntity, Integer> {

    @Query("SELECT s FROM RepartidoresEntity s WHERE s.estado = true")
    List<RepartidoresEntity> findAllCustom();
}
