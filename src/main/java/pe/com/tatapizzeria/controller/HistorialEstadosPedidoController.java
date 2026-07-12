package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;

@Controller
@RequestMapping("/historial")
public class HistorialEstadosPedidoController {

    @Autowired
    private HistorialEstadosPedidoService servicio;

    @GetMapping("/listar")
    public String MostrarListarHistorial(Model modelo) {
        modelo.addAttribute("listarhistorial", servicio.findAll());
        return "historial/listarhistorial";
    }

    @ModelAttribute("historial")
    public HistorialEstadosPedidoEntity ModeloHistorial() {
        return new HistorialEstadosPedidoEntity();
    }
}
