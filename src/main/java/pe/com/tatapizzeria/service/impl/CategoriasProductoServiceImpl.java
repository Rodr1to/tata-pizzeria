package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;
import pe.com.tatapizzeria.repository.CategoriasProductoRepository;
import pe.com.tatapizzeria.service.CategoriasProductoService;
import java.util.List;

@Service
public class CategoriasProductoServiceImpl implements CategoriasProductoService {

    @Autowired
    private CategoriasProductoRepository repositorio;

    @Override
    public List<CategoriasProductoEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<CategoriasProductoEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public CategoriasProductoEntity findById(Integer id) { return repositorio.findById(id).orElse(null); }

    @Override
    public CategoriasProductoEntity add(CategoriasProductoEntity obj) { return repositorio.save(obj); }

    @Override
    public CategoriasProductoEntity update(CategoriasProductoEntity obj, Integer id) {
        CategoriasProductoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public CategoriasProductoEntity delete(Integer id) {
        CategoriasProductoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public CategoriasProductoEntity enable(Integer id) {
        CategoriasProductoEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
