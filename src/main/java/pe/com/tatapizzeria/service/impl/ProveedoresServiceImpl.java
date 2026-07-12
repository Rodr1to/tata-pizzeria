package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.ProveedoresEntity;
import pe.com.tatapizzeria.repository.ProveedoresRepository;
import pe.com.tatapizzeria.service.ProveedoresService;
import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository repositorio;

    @Override
    public List<ProveedoresEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<ProveedoresEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public ProveedoresEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public ProveedoresEntity add(ProveedoresEntity obj) { return repositorio.save(obj); }

    @Override
    public ProveedoresEntity update(ProveedoresEntity obj, Long id) {
        ProveedoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ProveedoresEntity delete(Long id) {
        ProveedoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ProveedoresEntity enable(Long id) {
        ProveedoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}