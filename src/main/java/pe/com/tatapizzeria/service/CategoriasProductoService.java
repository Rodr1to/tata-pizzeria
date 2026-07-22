package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;

public interface CategoriasProductoService {
    List<CategoriasProductoEntity> findAll();
    List<CategoriasProductoEntity> findAllCustom();
    CategoriasProductoEntity findById(Long id);
    CategoriasProductoEntity add(CategoriasProductoEntity obj);
    CategoriasProductoEntity update(CategoriasProductoEntity obj, Long id);
    CategoriasProductoEntity delete(Long id);
    CategoriasProductoEntity enable(Long id);
    
}
