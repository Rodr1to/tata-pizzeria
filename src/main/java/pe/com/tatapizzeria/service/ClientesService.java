package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ClientesEntity;

public interface ClientesService {
    List<ClientesEntity> findAll();
    List<ClientesEntity> findAllCustom();
    ClientesEntity findById(Integer id);
    ClientesEntity add(ClientesEntity obj);
    ClientesEntity update(ClientesEntity obj,Integer id);
    ClientesEntity delete(Integer id);
    ClientesEntity enable(Integer id);
}
