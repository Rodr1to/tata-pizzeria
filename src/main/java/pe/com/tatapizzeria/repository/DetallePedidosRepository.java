package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import java.util.List;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity, Long> {

    @Query("SELECT d FROM DetallePedidosEntity d WHERE d.estado = true")
    List<DetallePedidosEntity> findAllCustom();

    @Query("SELECT d FROM DetallePedidosEntity d WHERE d.pedido.id = ?1 AND d.estado = true")
    List<DetallePedidosEntity> findByPedidoId(Long idPedido);
    
    // Para recalcular montos
    @Query("SELECT d FROM DetallePedidosEntity d WHERE d.pedido.id = ?1 AND d.estado = true")
    List<DetallePedidosEntity> findByPedidoIdAndEstadoTrue(Long idPedido);
}