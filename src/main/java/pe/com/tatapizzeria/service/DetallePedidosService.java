package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;

public interface DetallePedidosService {
    List<DetallePedidosEntity> findAll();
    List<DetallePedidosEntity> findAllCustom();
    DetallePedidosEntity findById(Long id);
    DetallePedidosEntity add(DetallePedidosEntity obj);
    DetallePedidosEntity update(DetallePedidosEntity obj, Long id);
    DetallePedidosEntity delete(Long id);
    DetallePedidosEntity enable(Long id);
}
