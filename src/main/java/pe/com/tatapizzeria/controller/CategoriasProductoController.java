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
    public String MostrarActualizarCategorias(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("categorias", servicio.findById(id));
        return "categorias/actualizarcategorias";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarCategorias(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/categorias/listar";
    }

    @ModelAttribute("categoria")
    public CategoriasProductoEntity ModeloCategorias() {
        return new CategoriasProductoEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarCategorias(@ModelAttribute("categoria") CategoriasProductoEntity obj) {
        servicio.add(obj);
        return "redirect:/categorias/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarCategorias(@ModelAttribute("categoria") CategoriasProductoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/categorias/listar";
    }
}
