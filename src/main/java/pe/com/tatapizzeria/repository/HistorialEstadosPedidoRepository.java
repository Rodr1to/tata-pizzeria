package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import java.util.List;

public interface HistorialEstadosPedidoRepository extends JpaRepository<HistorialEstadosPedidoEntity, Integer> {

    // Obtener TODOS los historiales de un pedido (ordenados de más antiguo a más nuevo)
    @Query("SELECT h FROM HistorialEstadosPedidoEntity h WHERE h.pedido.id = :idPedido ORDER BY h.fechaHoraCambio ASC")
    List<HistorialEstadosPedidoEntity> findByPedidoIdOrderByFechaHoraCambioAsc(@Param("idPedido") Integer idPedido);

    // Obtener el último estado de un pedido específico
    @Query("SELECT h FROM HistorialEstadosPedidoEntity h WHERE h.pedido.id = :idPedido ORDER BY h.fechaHoraCambio DESC")
    List<HistorialEstadosPedidoEntity> findLastEstadoByPedidoId(@Param("idPedido") Integer idPedido);
    
    // Obtener el último estado de cada pedido (usando subconsulta)
    @Query("SELECT h FROM HistorialEstadosPedidoEntity h WHERE h.fechaHoraCambio = (SELECT MAX(h2.fechaHoraCambio) FROM HistorialEstadosPedidoEntity h2 WHERE h2.pedido.id = h.pedido.id) ORDER BY h.pedido.id DESC")
    List<HistorialEstadosPedidoEntity> findLastEstadoForEachPedido();
    
    

    
}