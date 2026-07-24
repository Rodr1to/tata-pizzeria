package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;
import pe.com.tatapizzeria.service.CategoriasProductoService;

@Controller
@RequestMapping("/categorias")
public class CategoriasProductoController {

    @Autowired
    private CategoriasProductoService servicio;

    @GetMapping("/listar")
    public String MostrarListarCategorias(Model modelo) {
        modelo.addAttribute("listarcategorias", servicio.findAllCustom());
        return "categorias/listarcategorias";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarCategorias() {
        return "categorias/registrarcategorias";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarCategorias(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("categorias", servicio.findById(id));
        return "categorias/actualizarcategorias";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarCategorias(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/categorias/listar";
    }

    @ModelAttribute("categoria")
    public CategoriasProductoEntity ModeloCategorias() {
        CategoriasProductoEntity categoria = new CategoriasProductoEntity();
        categoria.setEstado(true); 
        return categoria;
    }

    @PostMapping("/registrar")
    public String RegistrarCategorias(@ModelAttribute("categoria") CategoriasProductoEntity obj) {
        servicio.add(obj);
        return "redirect:/categorias/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarCategorias(@ModelAttribute("categoria") CategoriasProductoEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/categorias/listar";
    }
    
    
    @GetMapping("/habilita")
    public String MostrarHabilitarCategorias(Model modelo) {
        modelo.addAttribute("listarcategorias", servicio.findAll());
        return "categorias/habilitarcategorias";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarCategorias(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/categorias/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarCategorias(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/categorias/habilita";
    }
    
}
