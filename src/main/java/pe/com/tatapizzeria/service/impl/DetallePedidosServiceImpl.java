package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.repository.DetallePedidosRepository;
import pe.com.tatapizzeria.service.DetallePedidosService;
import java.util.List;

@Service
public class DetallePedidosServiceImpl implements DetallePedidosService {

    @Autowired
    private DetallePedidosRepository repositorio;

    @Override
    public List<DetallePedidosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<DetallePedidosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public DetallePedidosEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public DetallePedidosEntity add(DetallePedidosEntity obj) { return repositorio.save(obj); }

    @Override
    public DetallePedidosEntity update(DetallePedidosEntity obj, Long id) {
        DetallePedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public DetallePedidosEntity delete(Long id) {
        DetallePedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public DetallePedidosEntity enable(Long id) {
        DetallePedidosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
    
    @Override
    public List<DetallePedidosEntity> findByPedidoId(Long idPedido) {
        return repositorio.findByPedidoId(idPedido);
    }
}
