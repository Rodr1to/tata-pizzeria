package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;

public interface HistorialEstadosPedidoService {
    List<HistorialEstadosPedidoEntity> findAll();
    HistorialEstadosPedidoEntity findById(Long id);
    HistorialEstadosPedidoEntity add(HistorialEstadosPedidoEntity obj);
}
