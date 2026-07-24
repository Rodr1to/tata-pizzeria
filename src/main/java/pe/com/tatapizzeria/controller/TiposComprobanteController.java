package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;
import pe.com.tatapizzeria.service.TiposComprobanteService;

@Controller
@RequestMapping("/tiposcomprobante")
public class TiposComprobanteController {

    @Autowired
    private TiposComprobanteService servicio;

    @GetMapping("/listar")
    public String MostrarListarTipos(Model modelo) {
        modelo.addAttribute("listartipos", servicio.findAllCustom());
        return "tiposcomprobante/listartipos";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarTipos() {
        return "tiposcomprobante/registrartipos";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarTipos(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("tiposcomprobante", servicio.findById(id));
        return "tiposcomprobante/actualizartipos";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarTipos(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/tiposcomprobante/listar";
    }

    
    @ModelAttribute("tipo")
    public TiposComprobanteEntity ModeloTipos() {
    	
    	TiposComprobanteEntity tipocomprobante = new TiposComprobanteEntity();
    	tipocomprobante.setEstado(true); 
    	
        return tipocomprobante;
        
    }

    @PostMapping("/registrar")
    public String RegistrarTipos(@ModelAttribute("tipo") TiposComprobanteEntity obj) {
        servicio.add(obj);
        return "redirect:/tiposcomprobante/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarTipos(@ModelAttribute("tipo") TiposComprobanteEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/tiposcomprobante/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarTipos(Model modelo) {
        modelo.addAttribute("listartipos", servicio.findAll());
        return "tiposcomprobante/habilitartiposcomprobante";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarTipos(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/tiposcomprobante/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarTipos(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/tiposcomprobante/habilita";
    }
}
