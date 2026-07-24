package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.repository.DetallePedidosRepository;
import pe.com.tatapizzeria.service.DetallePedidosService;
import pe.com.tatapizzeria.service.PedidosService;
import java.util.List;

@Service
public class DetallePedidosServiceImpl implements DetallePedidosService {

    @Autowired
    private DetallePedidosRepository repository;

    @Autowired
    private PedidosService pedidosService;

    @Override
    public List<DetallePedidosEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DetallePedidosEntity> findAllCustom() {
        return repository.findAllCustom();
    }

    @Override
    public DetallePedidosEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DetallePedidosEntity add(DetallePedidosEntity obj) {
        var detalleGuardado = repository.save(obj);
        // Recalcular montos del pedido después de agregar
        pedidosService.recalcularMontos(detalleGuardado.getPedido().getId());
        return detalleGuardado;
    }

    @Override
    @Transactional
    public DetallePedidosEntity update(DetallePedidosEntity obj, Integer id) {
        obj.setId(id);
        var detalleActualizado = repository.save(obj);
        // Recalcular montos del pedido después de actualizar
        pedidosService.recalcularMontos(detalleActualizado.getPedido().getId());
        return detalleActualizado;
    }

    @Override
    @Transactional
    public DetallePedidosEntity delete(Integer id) {
        var obj = findById(id);
        if (obj != null) {
            obj.setEstado(false);
            var detalleActualizado = repository.save(obj);
            // Recalcular montos del pedido después de eliminar
            pedidosService.recalcularMontos(detalleActualizado.getPedido().getId());
            return detalleActualizado;
        }
        return null;
    }

    @Override
    @Transactional
    public DetallePedidosEntity enable(Integer id) {
        var obj = findById(id);
        if (obj != null) {
            obj.setEstado(true);
            var detalleActualizado = repository.save(obj);
            // Recalcular montos del pedido después de habilitar
            pedidosService.recalcularMontos(detalleActualizado.getPedido().getId());
            return detalleActualizado;
        }
        return null;
    }

    @Override
    public List<DetallePedidosEntity> findByPedidoId(Integer idPedido) {
        return repository.findByPedidoId(idPedido);
    }
}