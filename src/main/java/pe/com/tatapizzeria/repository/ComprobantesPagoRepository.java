package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import java.util.List;

public interface ComprobantesPagoRepository extends JpaRepository<ComprobantesPagoEntity, Long> {

    @Query("SELECT s FROM ComprobantesPagoEntity s WHERE s.estado = true")
    List<ComprobantesPagoEntity> findAllCustom();
}
