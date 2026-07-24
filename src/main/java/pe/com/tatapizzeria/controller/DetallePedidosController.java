package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.service.DetallePedidosService;
import pe.com.tatapizzeria.service.PreciosVariantesService;
import pe.com.tatapizzeria.service.BordesRellenoService;
import pe.com.tatapizzeria.service.PedidosService;

@Controller
@RequestMapping("/detalles")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosService servicio;

    @Autowired
    private PreciosVariantesService servicioVariante;

    @Autowired
    private BordesRellenoService servicioBorde;

    @Autowired
    private PedidosService servicioPedido; 

    @GetMapping("/listar")
    public String MostrarListarDetalles(Model modelo) {
        modelo.addAttribute("listardetalles", servicio.findAllCustom());
        return "detalles/listardetalles";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarDetalles(Model modelo) {
        modelo.addAttribute("listarvariantes", servicioVariante.findAllCustom());
        modelo.addAttribute("listarbordes", servicioBorde.findAllCustom());
        return "detalles/registrardetalles";
    }

    @GetMapping("/registroConPedido/{idPedido}")
    public String MostrarRegistrarDetallesConPedido(Model modelo, @PathVariable Integer idPedido) {
        modelo.addAttribute("idPedidoSeleccionado", idPedido);
        modelo.addAttribute("listarvariantes", servicioVariante.findAllCustom());
        modelo.addAttribute("listarbordes", servicioBorde.findAllCustom());
        return "detalles/registrardetalles";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarDetalles(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("detalles", servicio.findById(id));
        modelo.addAttribute("listarvariantes", servicioVariante.findAllCustom());
        modelo.addAttribute("listarbordes", servicioBorde.findAllCustom());
        return "detalles/actualizardetalles";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDetalles(@PathVariable Integer id) {
        var detalle = servicio.findById(id);
        Integer idPedido = detalle.getPedido().getId();
        servicio.delete(id);
        // Recalcular montos después de eliminar
        servicioPedido.recalcularMontos(idPedido);
        return "redirect:/pedidos/detalles/" + idPedido;
    }

    @ModelAttribute("detalle")
    public DetallePedidosEntity ModeloDetalles() {
        DetallePedidosEntity detalle = new DetallePedidosEntity();
        detalle.setEstado(true);
        return detalle;
    }

    @PostMapping("/registrar")
    public String RegistrarDetalles(@ModelAttribute("detalle") DetallePedidosEntity obj) {
        servicio.add(obj);
        return "redirect:/pedidos/detalles/" + obj.getPedido().getId();
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarDetalles(@ModelAttribute("detalle") DetallePedidosEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/pedidos/detalles/" + obj.getPedido().getId();
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarDetalles(Model modelo) {
        modelo.addAttribute("listardetalles", servicio.findAll());
        return "detalles/habilitardetalles";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarDetalles(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/detalles/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarDetalles(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/detalles/habilita";
    }
}