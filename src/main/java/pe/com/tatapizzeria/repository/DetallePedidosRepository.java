package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import java.util.List;

public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity, Long> {

    @Query("SELECT s FROM DetallePedidosEntity s WHERE s.estado = true")
    List<DetallePedidosEntity> findAllCustom();
}
