package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.ProductosEntity;
import pe.com.tatapizzeria.repository.ProductosRepository;
import pe.com.tatapizzeria.service.ProductosService;
import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository repositorio;

    @Override
    public List<ProductosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<ProductosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public ProductosEntity findById(Integer id) { return repositorio.findById(id).orElse(null); }

    @Override
    public ProductosEntity add(ProductosEntity obj) { return repositorio.save(obj); }

    @Override
    public ProductosEntity update(ProductosEntity obj, Integer id) {
        ProductosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ProductosEntity delete(Integer id) {
        ProductosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public ProductosEntity enable(Integer id) {
        ProductosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
