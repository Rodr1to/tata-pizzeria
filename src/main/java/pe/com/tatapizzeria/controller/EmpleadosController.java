package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.EmpleadosEntity;
import pe.com.tatapizzeria.service.EmpleadosService;
import pe.com.tatapizzeria.service.SedesService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService servicio;

    @Autowired
    private SedesService servicioSede;

    @GetMapping("/listar")
    public String MostrarListarEmpleados(Model modelo) {
        modelo.addAttribute("listarempleados", servicio.findAllCustom());
        return "empleados/listarempleados";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarEmpleados(Model modelo) {
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        return "empleados/registrarempleados";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarEmpleados(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarsedes", servicioSede.findAllCustom());
        modelo.addAttribute("empleados", servicio.findById(id));
        return "empleados/actualizarempleados";
    }

    @GetMapping("/habilita")
    public String MostrarHabilitarEmpleados(Model modelo) {
        modelo.addAttribute("listarempleados", servicio.findAll());
        return "empleados/habilitarempleados";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarEmpleados(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleados/listar";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarEmpleados(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/empleados/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarEmpleados(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleados/habilita";
    }

    @ModelAttribute("empleado")
    public EmpleadosEntity ModeloEmpleados() {
        return new EmpleadosEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarEmpleados(@ModelAttribute("empleado") EmpleadosEntity obj) {
        servicio.add(obj);
        return "redirect:/empleados/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarEmpleados(@ModelAttribute("empleado") EmpleadosEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/empleados/listar";
    }
}
