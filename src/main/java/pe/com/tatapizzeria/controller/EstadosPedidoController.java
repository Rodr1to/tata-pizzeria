package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.entity.UsuariosEntity;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;
import pe.com.tatapizzeria.service.PedidosService;
import pe.com.tatapizzeria.service.UsuariosService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/estados")
public class EstadosPedidoController {

    @Autowired
    private HistorialEstadosPedidoService historialService;

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private UsuariosService usuarioService;

    //  Método para obtener usuario por defecto o el primero disponible
    private UsuariosEntity getUsuarioPorDefecto() {
        try {
            // Intentar obtener el primer usuario de la base de datos
            var usuarios = usuarioService.findAll();
            if (!usuarios.isEmpty()) {
                return usuarios.get(0);
            }
        } catch (Exception e) {
            // Si hay error, continuar
        }
        
        // Si no hay usuarios, crear uno temporal (solo para evitar el error)
        UsuariosEntity usuarioTemporal = new UsuariosEntity();
        usuarioTemporal.setId(1L);
        return usuarioTemporal;
    }

    @GetMapping("/cambiar/{idPedido}")
    public String MostrarCambiarEstado(Model modelo, @PathVariable Long idPedido) {
        var pedido = pedidosService.findById(idPedido);
        modelo.addAttribute("pedido", pedido);
        
        String[] estados = {"CREADO", "RECIBIDO", "EN_PREPARACION", "LISTO", "EN_CAMINO", "ENTREGADO", "CANCELADO"};
        modelo.addAttribute("estados", estados);
        
        var estadoActual = historialService.findLastEstadoByPedidoId(idPedido);
        modelo.addAttribute("estadoActual", estadoActual != null ? estadoActual.getEstado() : "CREADO");
        
        return "estados/cambiarestado";
    }

    @PostMapping("/cambiar")
    public String CambiarEstado(@RequestParam Long idPedido, 
                                @RequestParam String nuevoEstado,
                                @RequestParam(required = false) String observacion) {
        var pedido = pedidosService.findById(idPedido);
        if (pedido == null) {
            return "redirect:/pedidos/listar";
        }

        // Obtener usuario actual o usuario por defecto
        UsuariosEntity usuario = getUsuarioPorDefecto();

        HistorialEstadosPedidoEntity historial = new HistorialEstadosPedidoEntity();
        historial.setPedido(pedido);
        historial.setEstado(nuevoEstado);
        historial.setFechaHoraCambio(LocalDateTime.now());
        historial.setUsuarioCambio(usuario); // Asignar usuario no nulo
        
        historialService.add(historial);
        pedidosService.recalcularMontos(idPedido);
        
        return "redirect:/pedidos/detalles/" + idPedido;
    }
}