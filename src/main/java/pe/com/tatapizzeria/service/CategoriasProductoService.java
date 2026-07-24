package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;

public interface CategoriasProductoService {
    List<CategoriasProductoEntity> findAll();
    List<CategoriasProductoEntity> findAllCustom();
    CategoriasProductoEntity findById(Integer id);
    CategoriasProductoEntity add(CategoriasProductoEntity obj);
    CategoriasProductoEntity update(CategoriasProductoEntity obj,Integer id);
    CategoriasProductoEntity delete(Integer id);
    CategoriasProductoEntity enable(Integer id);
    
}
