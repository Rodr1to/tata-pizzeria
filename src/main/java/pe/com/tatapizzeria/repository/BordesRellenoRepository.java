package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;
import java.util.List;

public interface BordesRellenoRepository extends JpaRepository<BordesRellenoEntity, Long> {

    @Query("SELECT s FROM BordesRellenoEntity s WHERE s.estado = true")
    List<BordesRellenoEntity> findAllCustom();
}
