package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ClientesEntity;

public interface ClientesService {
    List<ClientesEntity> findAll();
    List<ClientesEntity> findAllCustom();
    ClientesEntity findById(Long id);
    ClientesEntity add(ClientesEntity obj);
    ClientesEntity update(ClientesEntity obj, Long id);
    ClientesEntity delete(Long id);
    ClientesEntity enable(Long id);
}
