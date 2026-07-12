package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.UsuariosEntity;
import pe.com.tatapizzeria.service.UsuariosService;
import pe.com.tatapizzeria.service.EmpleadosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService servicio;

    @Autowired
    private EmpleadosService servicioEmp;

    @GetMapping("/listar")
    public String MostrarListarUsuarios(Model modelo) {
        modelo.addAttribute("listarusuarios", servicio.findAllCustom());
        return "usuarios/listarusuarios";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarUsuarios(Model modelo) {
        modelo.addAttribute("listarempleados", servicioEmp.findAllCustom());
        return "usuarios/registrarusuarios";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarUsuarios(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarempleados", servicioEmp.findAllCustom());
        modelo.addAttribute("usuarios", servicio.findById(id));
        return "usuarios/actualizarusuarios";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarUsuarios(Model modelo) {
        modelo.addAttribute("listarusuarios", servicio.findAll());
        return "usuarios/habilitarusuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarUsuarios(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarUsuarios(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/usuarios/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarUsuarios(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/usuarios/habilita";
    }

    @ModelAttribute("usuario")
    public UsuariosEntity ModeloUsuarios() {
        return new UsuariosEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarUsuarios(@ModelAttribute("usuario") UsuariosEntity obj) {
        servicio.add(obj);
        return "redirect:/usuarios/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarUsuarios(@ModelAttribute("usuario") UsuariosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/usuarios/listar";
    }
}
