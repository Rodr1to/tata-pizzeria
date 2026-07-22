package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.repository.HistorialEstadosPedidoRepository;
import pe.com.tatapizzeria.repository.PedidosRepository;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class HistorialEstadosPedidoServiceImpl implements HistorialEstadosPedidoService {

    @Autowired
    private HistorialEstadosPedidoRepository repository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    public List<HistorialEstadosPedidoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public HistorialEstadosPedidoEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public HistorialEstadosPedidoEntity add(HistorialEstadosPedidoEntity obj) {
        return repository.save(obj);
    }

    // Obtener TODOS los historiales de un pedido
    @Override
    public List<HistorialEstadosPedidoEntity> findByPedidoId(Long idPedido) {
        return repository.findByPedidoIdOrderByFechaHoraCambioAsc(idPedido);
    }

    @Override
    public HistorialEstadosPedidoEntity findLastEstadoByPedidoId(Long idPedido) {
        List<HistorialEstadosPedidoEntity> historial = repository.findLastEstadoByPedidoId(idPedido);
        return historial.isEmpty() ? null : historial.get(0);
    }

    @Override
    public List<HistorialEstadosPedidoEntity> findLastEstadoForEachPedido() {
        return repository.findLastEstadoForEachPedido();
    }

    @Transactional
    public HistorialEstadosPedidoEntity actualizarEstadoPedido(Long idPedido, String nuevoEstado, Long idUsuario) {
        var pedido = pedidosRepository.findById(idPedido).orElse(null);
        if (pedido == null) return null;

        HistorialEstadosPedidoEntity historial = new HistorialEstadosPedidoEntity();
        historial.setPedido(pedido);
        historial.setEstado(nuevoEstado);
        historial.setFechaHoraCambio(LocalDateTime.now());
        
        return repository.save(historial);
    }
}