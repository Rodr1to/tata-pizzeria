package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.tatapizzeria.entity.BordesRellenoEntity;
import pe.com.tatapizzeria.entity.ProductosEntity;
import pe.com.tatapizzeria.service.ProductosService;
import pe.com.tatapizzeria.service.CategoriasProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService servicio;

    @Autowired
    private CategoriasProductoService servicioCat;

    @GetMapping("/listar")
    public String MostrarListarProductos(Model modelo) {
        modelo.addAttribute("listarproductos", servicio.findAllCustom());
        return "productos/listarproductos";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarProductos(Model modelo) {
        modelo.addAttribute("listarcategorias", servicioCat.findAllCustom());
        return "productos/registrarproductos";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarProductos(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarcategorias", servicioCat.findAllCustom());
        modelo.addAttribute("productos", servicio.findById(id));
        return "productos/actualizarproductos";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarProductos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/productos/listar";
    }

    @ModelAttribute("producto")
    public ProductosEntity ModeloProductos() {
    	ProductosEntity producto  = new ProductosEntity();
    	producto.setEstado(true); 
        return producto;
    }
       

    @PostMapping("/registrar")
    public String RegistrarProductos(@ModelAttribute("producto") ProductosEntity obj) {
        servicio.add(obj);
        return "redirect:/productos/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarProductos(@ModelAttribute("producto") ProductosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/productos/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarProductos(Model modelo) {
        modelo.addAttribute("listarproductos", servicio.findAll());
        return "productos/habilitarproductos";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarProductos(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/productos/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarProductos(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/productos/habilita";
    }
}
