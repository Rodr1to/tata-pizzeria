package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.UsuariosEntity;

public interface UsuariosService {
    List<UsuariosEntity> findAll();
    List<UsuariosEntity> findAllCustom();
    UsuariosEntity findById(Integer id);
    UsuariosEntity add(UsuariosEntity obj);
    UsuariosEntity update(UsuariosEntity obj,Integer id);
    UsuariosEntity delete(Integer id);
    UsuariosEntity enable(Integer id);
}
