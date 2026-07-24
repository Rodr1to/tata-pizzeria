package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ProveedoresEntity;

public interface ProveedoresService {
    List<ProveedoresEntity> findAll();
    List<ProveedoresEntity> findAllCustom();
    ProveedoresEntity findById(Integer id);
    ProveedoresEntity add(ProveedoresEntity obj);
    ProveedoresEntity update(ProveedoresEntity obj,Integer id);
    ProveedoresEntity delete(Integer id);
    ProveedoresEntity enable(Integer id);
}
