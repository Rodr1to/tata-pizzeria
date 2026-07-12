package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;
import pe.com.tatapizzeria.service.BordesRellenoService;

@Controller
@RequestMapping("/bordes")
public class BordesRellenoController {

    @Autowired
    private BordesRellenoService servicio;

    @GetMapping("/listar")
    public String MostrarListarBordes(Model modelo) {
        modelo.addAttribute("listarbordes", servicio.findAllCustom());
        return "bordes/listarbordes";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarBordes() {
        return "bordes/registrarbordes";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarBordes(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("bordes", servicio.findById(id));
        return "bordes/actualizarbordes";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarBordes(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/bordes/listar";
    }

    @ModelAttribute("borde")
    public BordesRellenoEntity ModeloBordes() {
        return new BordesRellenoEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarBordes(@ModelAttribute("borde") BordesRellenoEntity obj) {
        servicio.add(obj);
        return "redirect:/bordes/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarBordes(@ModelAttribute("borde") BordesRellenoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/bordes/listar";
    }
}
