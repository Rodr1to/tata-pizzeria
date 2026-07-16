package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.ClientesEntity;
import pe.com.tatapizzeria.repository.ClientesRepository;
import pe.com.tatapizzeria.service.ClientesService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository repositorio;

    @Override
    public List<ClientesEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<ClientesEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public ClientesEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public ClientesEntity add(ClientesEntity obj) {
        // Generar fecha automáticamente
        obj.setFechaRegistro(LocalDateTime.now());
        return repositorio.save(obj);
    }
    
    @Override
    public ClientesEntity update(ClientesEntity obj, Long id) {
        ClientesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "id", "fechaRegistro");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ClientesEntity delete(Long id) {
        ClientesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ClientesEntity enable(Long id) {
        ClientesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
