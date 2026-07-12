package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.TamanosEntity;
import pe.com.tatapizzeria.service.TamanosService;

@Controller
@RequestMapping("/tamanos")
public class TamanosController {

    @Autowired
    private TamanosService servicio;

    @GetMapping("/listar")
    public String MostrarListarTamanos(Model modelo) {
        modelo.addAttribute("listartamanos", servicio.findAllCustom());
        return "tamanos/listartamanos";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarTamanos() {
        return "tamanos/registrartamanos";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarTamanos(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("tamanos", servicio.findById(id));
        return "tamanos/actualizartamanos";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarTamanos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tamanos/listar";
    }

    @ModelAttribute("tamano")
    public TamanosEntity ModeloTamanos() {
        return new TamanosEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarTamanos(@ModelAttribute("tamano") TamanosEntity obj) {
        servicio.add(obj);
        return "redirect:/tamanos/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarTamanos(@ModelAttribute("tamano") TamanosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/tamanos/listar";
    }
}
