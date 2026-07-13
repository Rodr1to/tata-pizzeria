package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ClientesEntity;
import pe.com.tatapizzeria.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService servicio;

    @GetMapping("/listar")
    public String MostrarListarClientes(Model modelo) {
        modelo.addAttribute("listarclientes", servicio.findAllCustom());
        return "clientes/listarclientes";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarClientes() {
        return "clientes/registrarclientes";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarClientes(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("clientes", servicio.findById(id));
        return "clientes/actualizarclientes";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarClientes(Model modelo) {
        modelo.addAttribute("listarclientes", servicio.findAll());
        return "clientes/habilitarclientes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarClientes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarClientes(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/clientes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarClientes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/clientes/habilita";
    }

    @ModelAttribute("cliente")
    public ClientesEntity ModeloClientes() {
        return new ClientesEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarClientes(@ModelAttribute("cliente") ClientesEntity obj) {
        servicio.add(obj);
        return "redirect:/clientes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarClientes(@ModelAttribute("cliente") ClientesEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/clientes/listar";
    }
}