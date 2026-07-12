package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.RepartidoresEntity;
import pe.com.tatapizzeria.service.RepartidoresService;
import pe.com.tatapizzeria.service.SedesService;

@Controller
@RequestMapping("/repartidores")
public class RepartidoresController {

    @Autowired
    private RepartidoresService servicio;

    @Autowired
    private SedesService servicioSede;

    @GetMapping("/listar")
    public String MostrarListarRepartidores(Model modelo) {
        modelo.addAttribute("listarrepartidores", servicio.findAllCustom());
        return "repartidores/listarrepartidores";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarRepartidores(Model modelo) {
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        return "repartidores/registrarrepartidores";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarRepartidores(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        modelo.addAttribute("repartidores", servicio.findById(id));
        return "repartidores/actualizarrepartidores";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarRepartidores(Model modelo) {
        modelo.addAttribute("listarrepartidores", servicio.findAll());
        return "repartidores/habilitarrepartidores";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarRepartidores(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/repartidores/listar";
    }

    @ModelAttribute("repartidor")
    public RepartidoresEntity ModeloRepartidores() {
        return new RepartidoresEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarRepartidores(@ModelAttribute("repartidor") RepartidoresEntity obj) {
        servicio.add(obj);
        return "redirect:/repartidores/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarRepartidores(@ModelAttribute("repartidor") RepartidoresEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/repartidores/listar";
    }
}
