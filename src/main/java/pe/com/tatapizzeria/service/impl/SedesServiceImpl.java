package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.SedesEntity;
import pe.com.tatapizzeria.repository.SedesRepository;
import pe.com.tatapizzeria.service.SedesService;
import java.util.List;

@Service
public class SedesServiceImpl implements SedesService {

    @Autowired
    private SedesRepository repositorio;

    @Override
    public List<SedesEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<SedesEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public SedesEntity findById(Integer id) { return repositorio.findById(id).orElse(null); }

    @Override
    public SedesEntity add(SedesEntity obj) { return repositorio.save(obj); }

    @Override
    public SedesEntity update(SedesEntity obj, Integer id) {
        SedesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "id", "fechaRegistro");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public SedesEntity delete(Integer id) {
        SedesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public SedesEntity enable(Integer id) {
        SedesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
