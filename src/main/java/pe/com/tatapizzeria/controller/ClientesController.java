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
    public String MostrarActualizarClientes(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("clientes", servicio.findById(id));
        return "clientes/actualizarclientes";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarClientes(Model modelo) {
        modelo.addAttribute("listarclientes", servicio.findAll());
        return "clientes/habilitarclientes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarClientes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarClientes(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/clientes/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarClientes(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/clientes/habilita";
    }

    // ModelAttribute con estado activo por defecto
    @ModelAttribute("cliente")
    public ClientesEntity ModeloClientes() {
        ClientesEntity cliente = new ClientesEntity();
        cliente.setEstado(true); 
        return cliente;
    }

    @PostMapping("/registrar")
    public String RegistrarClientes(@ModelAttribute("cliente") ClientesEntity obj) {
        servicio.add(obj);
        return "redirect:/clientes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarClientes(@ModelAttribute("cliente") ClientesEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/clientes/listar";
    }
}