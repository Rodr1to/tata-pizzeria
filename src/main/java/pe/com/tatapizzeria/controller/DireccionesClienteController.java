package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;
import pe.com.tatapizzeria.service.DireccionesClienteService;
import pe.com.tatapizzeria.service.ClientesService;

@Controller
@RequestMapping("/direcciones")
public class DireccionesClienteController {

    @Autowired
    private DireccionesClienteService servicio;

    @Autowired
    private ClientesService servicioCli;

    @GetMapping("/listar")
    public String MostrarListarDirecciones(Model modelo) {
        modelo.addAttribute("listardirecciones", servicio.findAllCustom());
        return "direcciones/listardirecciones";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarDirecciones(Model modelo) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        return "direcciones/registrardirecciones";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarDirecciones(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        modelo.addAttribute("direcciones", servicio.findById(id));
        return "direcciones/actualizardirecciones";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDirecciones(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/direcciones/listar";
    }

    @ModelAttribute("direccion")
    public DireccionesClienteEntity ModeloDirecciones() {
        return new DireccionesClienteEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarDirecciones(@ModelAttribute("direccion") DireccionesClienteEntity obj) {
        servicio.add(obj);
        return "redirect:/direcciones/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarDirecciones(@ModelAttribute("direccion") DireccionesClienteEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/direcciones/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarDirecciones(Model modelo) {
        modelo.addAttribute("listardirecciones", servicio.findAll());
        return "direcciones/habilitardirecciones";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarDirecciones(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/direcciones/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarDirecciones(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/direcciones/habilita";
    }
    
    
    
}
