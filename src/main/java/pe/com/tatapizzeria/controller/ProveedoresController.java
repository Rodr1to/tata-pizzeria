package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ProveedoresEntity;
import pe.com.tatapizzeria.entity.RepartidoresEntity;
import pe.com.tatapizzeria.service.ProveedoresService;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService servicio;

    @GetMapping("/listar")
    public String MostrarListarProveedores(Model modelo) {
        modelo.addAttribute("listarproveedores", servicio.findAllCustom());
        return "proveedores/listarproveedores";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarProveedores() {
        return "proveedores/registrarproveedores";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarProveedores(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("proveedores", servicio.findById(id));
        return "proveedores/actualizarproveedores";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarProveedores(Model modelo) {
        modelo.addAttribute("listarproveedores", servicio.findAll());
        return "proveedores/habilitarproveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarProveedores(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/proveedores/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarProveedores(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/proveedores/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarProveedores(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/proveedores/habilita";
    }

    @ModelAttribute("proveedor")
    public ProveedoresEntity ModeloProveedores() {

        ProveedoresEntity provedor = new ProveedoresEntity();
        provedor.setEstado(true); 
        return provedor;
        
        
    }

    @PostMapping("/registrar")
    public String RegistrarProveedores(@ModelAttribute("proveedor") ProveedoresEntity obj) {
        servicio.add(obj);
        return "redirect:/proveedores/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarProveedores(@ModelAttribute("proveedor") ProveedoresEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/proveedores/listar";
    }
}
