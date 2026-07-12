package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.PedidosEntity;
import pe.com.tatapizzeria.repository.PedidosRepository;
import pe.com.tatapizzeria.service.PedidosService;
import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosRepository repositorio;

    @Override
    public List<PedidosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<PedidosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public PedidosEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public PedidosEntity add(PedidosEntity obj) { return repositorio.save(obj); }

    @Override
    public PedidosEntity update(PedidosEntity obj, Long id) {
        PedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public PedidosEntity delete(Long id) {
        PedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public PedidosEntity enable(Long id) {
        PedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
