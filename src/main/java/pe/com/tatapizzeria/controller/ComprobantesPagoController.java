package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import pe.com.tatapizzeria.service.ComprobantesPagoService;
import pe.com.tatapizzeria.service.TiposComprobanteService;

@Controller
@RequestMapping("/comprobantes")
public class ComprobantesPagoController {

    @Autowired
    private ComprobantesPagoService servicio;

    @Autowired
    private TiposComprobanteService servicioTipo;

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

    @GetMapping("/eliminar/{id}")
    public String EliminarComprobantes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/comprobantes/listar";
    }

    @ModelAttribute("comprobante")
    public ComprobantesPagoEntity ModeloComprobantes() {
        return new ComprobantesPagoEntity();
    }
}