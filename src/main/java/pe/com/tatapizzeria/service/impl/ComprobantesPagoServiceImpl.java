package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import pe.com.tatapizzeria.repository.ComprobantesPagoRepository;
import pe.com.tatapizzeria.service.ComprobantesPagoService;
import java.util.List;

@Service
public class ComprobantesPagoServiceImpl implements ComprobantesPagoService {

    @Autowired
    private ComprobantesPagoRepository repositorio;

    @Override
    public List<ComprobantesPagoEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<ComprobantesPagoEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public ComprobantesPagoEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public ComprobantesPagoEntity add(ComprobantesPagoEntity obj) { return repositorio.save(obj); }

    @Override
    public ComprobantesPagoEntity update(ComprobantesPagoEntity obj, Long id) {
        ComprobantesPagoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ComprobantesPagoEntity delete(Long id) {
        ComprobantesPagoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ComprobantesPagoEntity enable(Long id) {
        ComprobantesPagoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
