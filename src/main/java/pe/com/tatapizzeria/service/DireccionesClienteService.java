package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;

public interface DireccionesClienteService {
    List<DireccionesClienteEntity> findAll();
    List<DireccionesClienteEntity> findAllCustom();
    DireccionesClienteEntity findById(Integer id);
    DireccionesClienteEntity add(DireccionesClienteEntity obj);
    DireccionesClienteEntity update(DireccionesClienteEntity obj,Integer id);
    DireccionesClienteEntity delete(Integer id);
    DireccionesClienteEntity enable(Integer id);
    
    List<DireccionesClienteEntity> findByClienteId(Integer idCliente);

}
