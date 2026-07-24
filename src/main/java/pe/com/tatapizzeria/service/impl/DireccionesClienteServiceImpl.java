package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;
import pe.com.tatapizzeria.repository.DireccionesClienteRepository;
import pe.com.tatapizzeria.service.DireccionesClienteService;
import java.util.List;

@Service
public class DireccionesClienteServiceImpl implements DireccionesClienteService {

    @Autowired
    private DireccionesClienteRepository repositorio;

    @Override
    public List<DireccionesClienteEntity> findAll() { 
        return repositorio.findAll(); 
    }

    @Override
    public List<DireccionesClienteEntity> findAllCustom() { 
        return repositorio.findAllCustom(); 
    }

    @Override
    public DireccionesClienteEntity findById(Integer id) { 
        return repositorio.findById(id).orElse(null); 
    }

    @Override
    public DireccionesClienteEntity add(DireccionesClienteEntity obj) { 
        return repositorio.save(obj); 
    }

    @Override
    public DireccionesClienteEntity update(DireccionesClienteEntity obj, Integer id) {
        DireccionesClienteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "id");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public DireccionesClienteEntity delete(Integer id) {
        DireccionesClienteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public DireccionesClienteEntity enable(Integer id) {
        DireccionesClienteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }

    // 🔥 NUEVO MÉTODO
    @Override
    public List<DireccionesClienteEntity> findByClienteId(Integer idCliente) {
        return repositorio.findByClienteId(idCliente);
    }
}