package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.SedesEntity;
import pe.com.tatapizzeria.service.SedesService;

@Controller
@RequestMapping("/sedes")
public class SedesController {

    @Autowired
    private SedesService servicio;

    @GetMapping("/listar")
    public String MostrarListarSedes(Model modelo) {
        modelo.addAttribute("listarsedes", servicio.findAllCustom());
        return "sedes/listarsedes";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarSedes() {
        return "sedes/registrarsedes";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarSedes(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("sedes", servicio.findById(id));
        return "sedes/actualizarsedes";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarSedes(Model modelo) {
        modelo.addAttribute("listarsedes", servicio.findAll());
        return "sedes/habilitarsedes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarSedes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sedes/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarSedes(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/sedes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarSedes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sedes/habilita";
    }

    @ModelAttribute("sede")
    public SedesEntity ModeloSedes() {
        return new SedesEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarSedes(@ModelAttribute("sede") SedesEntity obj) {
        servicio.add(obj);
        return "redirect:/sedes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarSedes(@ModelAttribute("sede") SedesEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/sedes/listar";
    }
}
