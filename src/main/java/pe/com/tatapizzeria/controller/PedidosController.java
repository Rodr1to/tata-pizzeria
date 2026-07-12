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
        modelo.addAttribute("pedidos", servicio.findById(id));
        return "pedidos/actualizarpedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarPedidos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/pedidos/listar";
    }

    @ModelAttribute("pedido")
    public PedidosEntity ModeloPedidos() {
        return new PedidosEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarPedidos(@ModelAttribute("pedido") PedidosEntity obj) {
        servicio.add(obj);
        return "redirect:/pedidos/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarPedidos(@ModelAttribute("pedido") PedidosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/pedidos/listar";
    }
}
