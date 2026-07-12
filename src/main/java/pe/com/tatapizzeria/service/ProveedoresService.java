package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ProveedoresEntity;

public interface ProveedoresService {
    List<ProveedoresEntity> findAll();
    List<ProveedoresEntity> findAllCustom();
    ProveedoresEntity findById(Long id);
    ProveedoresEntity add(ProveedoresEntity obj);
    ProveedoresEntity update(ProveedoresEntity obj, Long id);
    ProveedoresEntity delete(Long id);
    ProveedoresEntity enable(Long id);
}
