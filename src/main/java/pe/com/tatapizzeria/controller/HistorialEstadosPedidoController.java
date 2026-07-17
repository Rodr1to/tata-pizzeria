package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;
import pe.com.tatapizzeria.service.PedidosService;

@Controller
@RequestMapping("/historial")
public class HistorialEstadosPedidoController {

    @Autowired
    private HistorialEstadosPedidoService servicio;

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/listar")
    public String MostrarListarHistorial(Model modelo) {
        // Obtener todos los pedidos con su último estado
        modelo.addAttribute("listarhistorial", servicio.findLastEstadoForEachPedido());
        return "historial/listarhistorial";
    }

    // 🔥 Ver historial COMPLETO de un pedido específico
    @GetMapping("/pedido/{idPedido}")
    public String MostrarHistorialPorPedido(Model modelo, @PathVariable Long idPedido) {
        var pedido = pedidosService.findById(idPedido);
        modelo.addAttribute("pedido", pedido);
        // 🔥 CORREGIDO: Usar findByPedidoId para obtener TODOS los estados
        modelo.addAttribute("listarhistorial", servicio.findByPedidoId(idPedido));
        return "historial/historialpedido";
    }

    @ModelAttribute("historial")
    public HistorialEstadosPedidoEntity ModeloHistorial() {
        return new HistorialEstadosPedidoEntity();
    }
}