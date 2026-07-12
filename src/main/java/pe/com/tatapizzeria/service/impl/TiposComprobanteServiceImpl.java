package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;
import pe.com.tatapizzeria.repository.TiposComprobanteRepository;
import pe.com.tatapizzeria.service.TiposComprobanteService;
import java.util.List;

@Service
public class TiposComprobanteServiceImpl implements TiposComprobanteService {

    @Autowired
    private TiposComprobanteRepository repositorio;

    @Override
    public List<TiposComprobanteEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<TiposComprobanteEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public TiposComprobanteEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public TiposComprobanteEntity add(TiposComprobanteEntity obj) { return repositorio.save(obj); }

    @Override
    public TiposComprobanteEntity update(TiposComprobanteEntity obj, Long id) {
        TiposComprobanteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public TiposComprobanteEntity delete(Long id) {
        TiposComprobanteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public TiposComprobanteEntity enable(Long id) {
        TiposComprobanteEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
