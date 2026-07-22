package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.PedidosEntity;
import pe.com.tatapizzeria.service.*;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService servicio;

    @Autowired
    private ClientesService servicioCli;

    @Autowired
    private SedesService servicioSede;

    @Autowired
    private UsuariosService servicioUsu;

    @Autowired
    private DetallePedidosService servicioDetalle;

    @GetMapping("/listar")
    public String MostrarListarPedidos(Model modelo) {
        modelo.addAttribute("listarpedidos", servicio.findAllCustom());
        return "pedidos/listarpedidos";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarPedidos(Model modelo) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        modelo.addAttribute("listarusuarios", servicioUsu.findAllCustom());
        return "pedidos/registrarpedidos";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarPedidos(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        modelo.addAttribute("listarusuarios", servicioUsu.findAllCustom()); 
        modelo.addAttribute("pedidos", servicio.findById(id));
        return "pedidos/actualizarpedidos";
    }

    @GetMapping("/detalles/{id}")
    public String MostrarDetallesPedido(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("pedido", servicio.findById(id));
        modelo.addAttribute("listardetalles", servicioDetalle.findByPedidoId(id));
        return "pedidos/detallepedido";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarPedidos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/pedidos/listar";
    }

    @ModelAttribute("pedido")
    public PedidosEntity ModeloPedidos() {
        PedidosEntity pedido = new PedidosEntity();
        pedido.setMontoSubtotal(0.0);
        pedido.setCostoDelivery(0.0);
        pedido.setMontoTotal(0.0);
        pedido.setEstado(true);
        return pedido;
    }

    @PostMapping("/registrar")
    public String RegistrarPedidos(@ModelAttribute("pedido") PedidosEntity obj) {
        var pedidoGuardado = servicio.add(obj);
        return "redirect:/pedidos/detalles/" + pedidoGuardado.getId();
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarPedidos(@ModelAttribute("pedido") PedidosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/pedidos/detalles/" + id;
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarPedidos(Model modelo) {
        modelo.addAttribute("listarpedidos", servicio.findAll());
        return "pedidos/habilitarpedidos";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarPedidos(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/pedidos/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarPedidos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/pedidos/habilita";
    }
}