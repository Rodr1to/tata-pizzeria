package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;

public interface HistorialEstadosPedidoService {
    List<HistorialEstadosPedidoEntity> findAll();
    HistorialEstadosPedidoEntity findById(Long id);
    HistorialEstadosPedidoEntity add(HistorialEstadosPedidoEntity obj);
    
    // Obtener TODOS los historiales de un pedido
    List<HistorialEstadosPedidoEntity> findByPedidoId(Long idPedido);
    
    // Obtener el último estado de un pedido
    HistorialEstadosPedidoEntity findLastEstadoByPedidoId(Long idPedido);
    
    // Obtener el último estado de cada pedido
    List<HistorialEstadosPedidoEntity> findLastEstadoForEachPedido();
}