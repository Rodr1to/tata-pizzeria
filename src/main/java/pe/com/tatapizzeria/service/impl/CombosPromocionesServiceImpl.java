package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;
import pe.com.tatapizzeria.repository.CombosPromocionesRepository;
import pe.com.tatapizzeria.service.CombosPromocionesService;
import java.util.List;

@Service
public class CombosPromocionesServiceImpl implements CombosPromocionesService {

    @Autowired
    private CombosPromocionesRepository repositorio;

    @Override
    public List<CombosPromocionesEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<CombosPromocionesEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public CombosPromocionesEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public CombosPromocionesEntity add(CombosPromocionesEntity obj) { return repositorio.save(obj); }

    @Override
    public CombosPromocionesEntity update(CombosPromocionesEntity obj, Long id) {
        CombosPromocionesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public CombosPromocionesEntity delete(Long id) {
        CombosPromocionesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public CombosPromocionesEntity enable(Long id) {
        CombosPromocionesEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}