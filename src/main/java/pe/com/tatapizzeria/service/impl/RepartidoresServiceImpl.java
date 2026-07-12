package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.RepartidoresEntity;
import pe.com.tatapizzeria.repository.RepartidoresRepository;
import pe.com.tatapizzeria.service.RepartidoresService;
import java.util.List;

@Service
public class RepartidoresServiceImpl implements RepartidoresService {

    @Autowired
    private RepartidoresRepository repositorio;

    @Override
    public List<RepartidoresEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<RepartidoresEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public RepartidoresEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public RepartidoresEntity add(RepartidoresEntity obj) { return repositorio.save(obj); }

    @Override
    public RepartidoresEntity update(RepartidoresEntity obj, Long id) {
        RepartidoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public RepartidoresEntity delete(Long id) {
        RepartidoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public RepartidoresEntity enable(Long id) {
        RepartidoresEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}