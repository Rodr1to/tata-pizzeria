package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;
import pe.com.tatapizzeria.repository.PreciosVariantesRepository;
import pe.com.tatapizzeria.service.PreciosVariantesService;
import java.util.List;

@Service
public class PreciosVariantesServiceImpl implements PreciosVariantesService {

    @Autowired
    private PreciosVariantesRepository repositorio;

    @Override
    public List<PreciosVariantesEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<PreciosVariantesEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public PreciosVariantesEntity findById(Integer id) { return repositorio.findById(id).orElse(null); }

    @Override
    public PreciosVariantesEntity add(PreciosVariantesEntity obj) { return repositorio.save(obj); }

    @Override
    public PreciosVariantesEntity update(PreciosVariantesEntity obj, Integer id) {
        PreciosVariantesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public PreciosVariantesEntity delete(Integer id) {
        PreciosVariantesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public PreciosVariantesEntity enable(Integer id) {
        PreciosVariantesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
