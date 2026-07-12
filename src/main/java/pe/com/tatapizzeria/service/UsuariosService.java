package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.UsuariosEntity;

public interface UsuariosService {
    List<UsuariosEntity> findAll();
    List<UsuariosEntity> findAllCustom();
    UsuariosEntity findById(Long id);
    UsuariosEntity add(UsuariosEntity obj);
    UsuariosEntity update(UsuariosEntity obj, Long id);
    UsuariosEntity delete(Long id);
    UsuariosEntity enable(Long id);
}
