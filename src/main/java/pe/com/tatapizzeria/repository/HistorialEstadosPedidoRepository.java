package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import java.util.List;

public interface HistorialEstadosPedidoRepository extends JpaRepository<HistorialEstadosPedidoEntity, Long> {

    @Query("SELECT s FROM HistorialEstadosPedidoEntity s WHERE s.estado = true")
    List<HistorialEstadosPedidoEntity> findAllCustom();
}
