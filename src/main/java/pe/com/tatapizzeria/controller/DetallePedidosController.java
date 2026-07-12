package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.service.DetallePedidosService;

@Controller
@RequestMapping("/detalles")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosService servicio;

    @GetMapping("/listar")
    public String MostrarListarDetalles(Model modelo) {
        modelo.addAttribute("listardetalles", servicio.findAllCustom());
        return "detalles/listardetalles";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDetalles(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/detalles/listar";
    }

    @ModelAttribute("detalle")
    public DetallePedidosEntity ModeloDetalles() {
        return new DetallePedidosEntity();
    }
}
