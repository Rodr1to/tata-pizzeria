package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;
import pe.com.tatapizzeria.entity.ProductosEntity;
import pe.com.tatapizzeria.service.PreciosVariantesService;
import pe.com.tatapizzeria.service.ProductosService;
import pe.com.tatapizzeria.service.TamanosService;

@Controller
@RequestMapping("/variantes")
public class PreciosVariantesController {

    @Autowired
    private PreciosVariantesService servicio;

    @Autowired
    private ProductosService servicioPro;

    @Autowired
    private TamanosService servicioTam;

    @GetMapping("/listar")
    public String MostrarListarVariantes(Model modelo) {
        modelo.addAttribute("listarvariantes", servicio.findAllCustom());
        return "variantes/listarvariantes";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarVariantes(Model modelo) {
        modelo.addAttribute("listarproductos", servicioPro.findAllCustom());
        modelo.addAttribute("listartamanos", servicioTam.findAllCustom());
        return "variantes/registrarvariantes";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarVariantes(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("listarproductos", servicioPro.findAllCustom());
        modelo.addAttribute("listartamanos", servicioTam.findAllCustom());
        modelo.addAttribute("variantes", servicio.findById(id));
        return "variantes/actualizarvariantes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarVariantes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/variantes/listar";
    }

    @ModelAttribute("variante")
    public PreciosVariantesEntity ModeloVariantes() {
    	
    	PreciosVariantesEntity precio  = new PreciosVariantesEntity();
    	precio.setEstado(true); 
        return precio;
    }

    
    @PostMapping("/registrar")
    public String RegistrarVariantes(@ModelAttribute("variante") PreciosVariantesEntity obj) {
        servicio.add(obj);
        return "redirect:/variantes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarVariantes(@ModelAttribute("variante") PreciosVariantesEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/variantes/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarVariantes(Model modelo) {
        modelo.addAttribute("listarvariantes", servicio.findAll());
        return "variantes/habilitarvariantes";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarVariantes(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/variantes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarVariantes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/variantes/habilita";
    }
}
