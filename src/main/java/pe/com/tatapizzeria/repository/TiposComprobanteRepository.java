package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;
import java.util.List;

public interface TiposComprobanteRepository extends JpaRepository<TiposComprobanteEntity, Integer> {

    @Query("SELECT s FROM TiposComprobanteEntity s WHERE s.estado = true")
    List<TiposComprobanteEntity> findAllCustom();
}
