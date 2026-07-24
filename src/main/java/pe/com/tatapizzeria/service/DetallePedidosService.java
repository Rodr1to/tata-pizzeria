package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;

public interface DetallePedidosService {
    List<DetallePedidosEntity> findAll();
    List<DetallePedidosEntity> findAllCustom();
    DetallePedidosEntity findById(Integer id);
    DetallePedidosEntity add(DetallePedidosEntity obj);
    DetallePedidosEntity update(DetallePedidosEntity obj,Integer id);
    DetallePedidosEntity delete(Integer id);
    DetallePedidosEntity enable(Integer id);
    List<DetallePedidosEntity> findByPedidoId(Integer idPedido);
}
