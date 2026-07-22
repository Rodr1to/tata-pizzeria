package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;
import pe.com.tatapizzeria.service.CombosPromocionesService;

@Controller
@RequestMapping("/combos")
public class CombosPromocionesController {

    @Autowired
    private CombosPromocionesService servicio;

    @GetMapping("/listar")
    public String MostrarListarCombos(Model modelo) {
        modelo.addAttribute("listarcombos", servicio.findAllCustom());
        return "combos/listarcombos";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarCombos() {
        return "combos/registrarcombos";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarCombos(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("combos", servicio.findById(id));
        return "combos/actualizarcombos";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarCombos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/combos/listar";
    }

    @ModelAttribute("combo")
    public CombosPromocionesEntity ModeloCombos() {
    	
    	CombosPromocionesEntity combo  = new CombosPromocionesEntity();
    	combo.setEstado(true); 
        return combo;
    }

    @PostMapping("/registrar")
    public String RegistrarCombos(@ModelAttribute("combo") CombosPromocionesEntity obj) {
        servicio.add(obj);
        return "redirect:/combos/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarCombos(@ModelAttribute("combo") CombosPromocionesEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/combos/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarCombos(Model modelo) {
        modelo.addAttribute("listarcombos", servicio.findAll());
        return "combos/habilitarcombos";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarCombos(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/combos/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarCombos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/combos/habilita";
    }
}
