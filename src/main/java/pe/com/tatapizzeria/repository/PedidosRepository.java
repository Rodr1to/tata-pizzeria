package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.PedidosEntity;
import java.util.List;

public interface PedidosRepository extends JpaRepository<PedidosEntity, Integer> {

    @Query("SELECT s FROM PedidosEntity s WHERE s.estado = true")
    List<PedidosEntity> findAllCustom();
}
