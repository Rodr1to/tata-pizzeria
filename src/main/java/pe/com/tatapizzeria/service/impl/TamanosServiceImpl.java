package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.TamanosEntity;
import pe.com.tatapizzeria.repository.TamanosRepository;
import pe.com.tatapizzeria.service.TamanosService;
import java.util.List;

@Service
public class TamanosServiceImpl implements TamanosService {

    @Autowired
    private TamanosRepository repositorio;

    @Override
    public List<TamanosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<TamanosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public TamanosEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public TamanosEntity add(TamanosEntity obj) { return repositorio.save(obj); }

    @Override
    public TamanosEntity update(TamanosEntity obj, Long id) {
        TamanosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public TamanosEntity delete(Long id) {
        TamanosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public TamanosEntity enable(Long id) {
        TamanosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
