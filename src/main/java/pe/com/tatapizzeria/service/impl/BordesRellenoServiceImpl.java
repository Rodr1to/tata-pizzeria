package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;
import pe.com.tatapizzeria.repository.BordesRellenoRepository;
import pe.com.tatapizzeria.service.BordesRellenoService;
import java.util.List;

@Service
public class BordesRellenoServiceImpl implements BordesRellenoService {

    @Autowired
    private BordesRellenoRepository repositorio;

    @Override
    public List<BordesRellenoEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<BordesRellenoEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public BordesRellenoEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public BordesRellenoEntity add(BordesRellenoEntity obj) { return repositorio.save(obj); }

    @Override
    public BordesRellenoEntity update(BordesRellenoEntity obj, Long id) {
        BordesRellenoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public BordesRellenoEntity delete(Long id) {
        BordesRellenoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public BordesRellenoEntity enable(Long id) {
        BordesRellenoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
