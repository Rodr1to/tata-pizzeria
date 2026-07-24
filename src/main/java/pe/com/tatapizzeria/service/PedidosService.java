package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.PedidosEntity;

public interface PedidosService {
    List<PedidosEntity> findAll();
    List<PedidosEntity> findAllCustom();
    PedidosEntity findById(Integer id);
    PedidosEntity add(PedidosEntity obj);
    PedidosEntity update(PedidosEntity obj,Integer id);
    PedidosEntity delete(Integer id);
    PedidosEntity enable(Integer id);
    
    
    // Recalcular montos
    PedidosEntity recalcularMontos(Integer idPedido);
}
