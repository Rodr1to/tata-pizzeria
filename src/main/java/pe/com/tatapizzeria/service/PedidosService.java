package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.PedidosEntity;

public interface PedidosService {
    List<PedidosEntity> findAll();
    List<PedidosEntity> findAllCustom();
    PedidosEntity findById(Long id);
    PedidosEntity add(PedidosEntity obj);
    PedidosEntity update(PedidosEntity obj, Long id);
    PedidosEntity delete(Long id);
    PedidosEntity enable(Long id);
    
    
    // Recalcular montos
    PedidosEntity recalcularMontos(Long idPedido);
}
