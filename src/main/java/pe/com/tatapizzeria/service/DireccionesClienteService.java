package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;

public interface DireccionesClienteService {
    List<DireccionesClienteEntity> findAll();
    List<DireccionesClienteEntity> findAllCustom();
    DireccionesClienteEntity findById(Long id);
    DireccionesClienteEntity add(DireccionesClienteEntity obj);
    DireccionesClienteEntity update(DireccionesClienteEntity obj, Long id);
    DireccionesClienteEntity delete(Long id);
    DireccionesClienteEntity enable(Long id);
}
