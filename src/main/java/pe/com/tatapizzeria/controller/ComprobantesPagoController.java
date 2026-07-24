package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import pe.com.tatapizzeria.entity.PedidosEntity;
import pe.com.tatapizzeria.service.ComprobantesPagoService;
import pe.com.tatapizzeria.service.TiposComprobanteService;
import pe.com.tatapizzeria.service.PedidosService;

@Controller
@RequestMapping("/comprobantes")
public class ComprobantesPagoController {

    @Autowired
    private ComprobantesPagoService servicio;

    @Autowired
    private TiposComprobanteService servicioTipo;

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/listar")
    public String MostrarListarComprobantes(Model modelo) {
        modelo.addAttribute("listarcomprobantes", servicio.findAllCustom());
        return "comprobantes/listarcomprobantes";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarComprobantes(Model modelo) {
        modelo.addAttribute("listartipos", servicioTipo.findAllCustom());
        return "comprobantes/registrarcomprobantes";
    }

    @GetMapping("/registroConPedido/{idPedido}")
    public String MostrarRegistrarComprobantesConPedido(Model modelo, @PathVariable Integer idPedido) {
        var pedido = pedidosService.findById(idPedido);
        
        if (pedido == null) {
            return "redirect:/pedidos/listar";
        }

        ComprobantesPagoEntity comprobante = new ComprobantesPagoEntity();
        comprobante.setPedido(pedido);
        comprobante.setMontoPagado(pedido.getMontoTotal());
        comprobante.setMetodoPago("EFECTIVO");
        comprobante.setEstadoPago("PAGADO");
        comprobante.setEstado(true);

        modelo.addAttribute("comprobante", comprobante);
        modelo.addAttribute("pedido", pedido);
        modelo.addAttribute("listartipos", servicioTipo.findAllCustom());

        return "comprobantes/registrarcomprobantes";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarComprobantes(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("listartipos", servicioTipo.findAllCustom());
        modelo.addAttribute("comprobantes", servicio.findById(id));
        return "comprobantes/actualizarcomprobantes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarComprobantes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/comprobantes/listar";
    }

    @ModelAttribute("comprobante")
    public ComprobantesPagoEntity ModeloComprobantes() {
        ComprobantesPagoEntity comprobante = new ComprobantesPagoEntity();
        comprobante.setEstado(true);
        comprobante.setVuelto(0.0);
        comprobante.setMontoPagado(0.0);
        comprobante.setMetodoPago("EFECTIVO"); // 🔥 Valor por defecto
        comprobante.setEstadoPago("PAGADO"); // 🔥 Valor por defecto
        comprobante.setPedido(new PedidosEntity());
        return comprobante;
    }

    @PostMapping("/registrar")
    public String RegistrarComprobantes(@ModelAttribute("comprobante") ComprobantesPagoEntity obj) {
        // Calcular vuelto si no viene
        if (obj.getVuelto() == null || obj.getVuelto() == 0.0) {
            var pedido = pedidosService.findById(obj.getPedido().getId());
            if (pedido != null) {
                obj.setVuelto(Math.max(0, obj.getMontoPagado() - pedido.getMontoTotal()));
            }
        }
        servicio.add(obj);
        return "redirect:/comprobantes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarComprobantes(@ModelAttribute("comprobante") ComprobantesPagoEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/comprobantes/listar";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarComprobantes(Model modelo) {
        modelo.addAttribute("listarcomprobantes", servicio.findAll());
        return "comprobantes/habilitarcomprobantes";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarComprobantes(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/comprobantes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarComprobantes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/comprobantes/habilita";
    }
}