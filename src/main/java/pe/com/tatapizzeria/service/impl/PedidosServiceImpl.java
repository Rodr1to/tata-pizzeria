package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tatapizzeria.entity.PedidosEntity;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.repository.PedidosRepository;
import pe.com.tatapizzeria.repository.DetallePedidosRepository;
import pe.com.tatapizzeria.service.PedidosService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosRepository repository;

    @Autowired
    private DetallePedidosRepository detalleRepository;

    @Override
    public List<PedidosEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PedidosEntity> findAllCustom() {
        return repository.findAllCustom();
    }

    @Override
    public PedidosEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PedidosEntity add(PedidosEntity obj) {
        //  Generar fecha y hora automáticamente
        obj.setFechaHoraPedido(LocalDateTime.now());
        
        // Inicializar montos
        obj.setMontoSubtotal(0.0);
        
        // Calcular costo delivery según tipo de entrega
        if ("DELIVERY".equalsIgnoreCase(obj.getTipoEntrega())) {
            obj.setCostoDelivery(5.0);
        } else {
            obj.setCostoDelivery(0.0);
        }
        
        // Calcular total inicial
        obj.setMontoTotal(obj.getCostoDelivery());
        
        return repository.save(obj);
    }

    @Override
    @Transactional
    public PedidosEntity update(PedidosEntity obj, Long id) {
        var existing = findById(id);
        if (existing != null) {
            existing.setCliente(obj.getCliente());
            existing.setSede(obj.getSede());
            existing.setUsuario(obj.getUsuario());
            existing.setDireccion(obj.getDireccion());
            existing.setRepartidor(obj.getRepartidor());
            // NO actualizar la fecha, mantener la existente
            // existing.setFechaHoraPedido(obj.getFechaHoraPedido());  
            existing.setTipoEntrega(obj.getTipoEntrega());
            existing.setOrigenPedido(obj.getOrigenPedido());
            existing.setObservaciones(obj.getObservaciones());
            existing.setEstado(obj.getEstado());
            
            // Recalcular montos
            recalcularMontos(id);
            
            return repository.save(existing);
        }
        return null;
    }

    @Override
    @Transactional
    public PedidosEntity delete(Long id) {
        var obj = findById(id);
        if (obj != null) {
            obj.setEstado(false);
            // Recalcular montos después de deshabilitar
            recalcularMontos(id);
            return repository.save(obj);
        }
        return null;
    }

    @Override
    @Transactional
    public PedidosEntity enable(Long id) {
        var obj = findById(id);
        if (obj != null) {
            obj.setEstado(true);
            // Recalcular montos después de habilitar
            recalcularMontos(id);
            return repository.save(obj);
        }
        return null;
    }

    //  MÉTODO: Recalcular montos
    @Override
    @Transactional
    public PedidosEntity recalcularMontos(Long idPedido) {
        var pedido = findById(idPedido);
        if (pedido == null) return null;

        // Obtener todos los detalles activos del pedido
        List<DetallePedidosEntity> detalles = detalleRepository.findByPedidoIdAndEstadoTrue(idPedido);
        
        // Calcular subtotal (suma de todos los montosSubtotal de los detalles)
        double subtotal = detalles.stream()
                .mapToDouble(DetallePedidosEntity::getMontoSubtotal)
                .sum();
        
        // Calcular costo delivery según tipo de entrega
        double costoDelivery = calcularCostoDelivery(pedido);
        
        // Calcular total
        double total = subtotal + costoDelivery;
        
        // Actualizar el pedido
        pedido.setMontoSubtotal(subtotal);
        pedido.setCostoDelivery(costoDelivery);
        pedido.setMontoTotal(total);
        
        return repository.save(pedido);
    }

    // Método auxiliar para calcular costo delivery
    private double calcularCostoDelivery(PedidosEntity pedido) {
        if (pedido == null) return 0.0;
        if ("DELIVERY".equalsIgnoreCase(pedido.getTipoEntrega())) {
            return 5.0; // Precio fijo para delivery
        }
        return 0.0; // Sin costo para RECOJO o SALON
    }
}