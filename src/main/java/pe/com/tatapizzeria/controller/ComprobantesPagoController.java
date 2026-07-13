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

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarComprobantes(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listartipos", servicioTipo.findAllCustom());
        modelo.addAttribute("comprobantes", servicio.findById(id));
        return "comprobantes/actualizarcomprobantes";
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

    
    @PostMapping("/registrar")
    public String RegistrarComprobantes(@ModelAttribute("comprobante") ComprobantesPagoEntity obj) {
        servicio.add(obj);
        return "redirect:/comprobantes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarComprobantes(@ModelAttribute("comprobante") ComprobantesPagoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/comprobantes/listar";
    }


    @GetMapping("/habilita")
    public String MostrarHabilitarComprobantes(Model modelo) {
        modelo.addAttribute("listarcomprobantes", servicio.findAll());
        return "comprobantes/habilitarcomprobantes";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarComprobantes(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/comprobantes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarComprobantes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/comprobantes/habilita";
    }
}