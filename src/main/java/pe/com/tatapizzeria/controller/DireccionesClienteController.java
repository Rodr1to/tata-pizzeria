package pe.com.tatapizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.tatapizzeria.entity.CombosPromocionesEntity;
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
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom()); //  Para el filtro
        return "direcciones/listardirecciones";
    }

    // NUEVO MÉTODO: Listar direcciones por cliente
    @GetMapping("/listarPorCliente/{idCliente}")
    public String MostrarListarDireccionesPorCliente(Model modelo, @PathVariable Integer idCliente) {
        // Obtener el cliente para mostrar su nombre
        var cliente = servicioCli.findById(idCliente);
        modelo.addAttribute("cliente", cliente);
        // Obtener direcciones de ese cliente
        modelo.addAttribute("listardirecciones", servicio.findByClienteId(idCliente));
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom()); // Para el filtro
        return "direcciones/listardirecciones";
    }

    //  NUEVO MÉTODO: Filtrar direcciones por cliente (con parámetro)
    @GetMapping("/filtrar")
    public String FiltrarDireccionesPorCliente(Model modelo, @RequestParam(required = false) Integer idCliente) {
        if (idCliente != null && idCliente > 0) {
            var cliente = servicioCli.findById(idCliente);
            modelo.addAttribute("cliente", cliente);
            modelo.addAttribute("listardirecciones", servicio.findByClienteId(idCliente));
        } else {
            modelo.addAttribute("listardirecciones", servicio.findAllCustom());
        }
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        return "direcciones/listardirecciones";
    }

    @GetMapping("/registro")
    public String MostrarRegistrarDirecciones(Model modelo) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        return "direcciones/registrardirecciones";
    }

    @GetMapping("/actualiza/{id}")
    public String MostrarActualizarDirecciones(Model modelo, @PathVariable Integer id) {
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        modelo.addAttribute("direcciones", servicio.findById(id));
        return "direcciones/actualizardirecciones";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDirecciones(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/direcciones/listar";
    }

    @ModelAttribute("direccion")
    public DireccionesClienteEntity ModeloDirecciones() {
    	DireccionesClienteEntity direccion  = new DireccionesClienteEntity();
    	direccion.setEstado(true); 
        return direccion;
    }

    
    
    @PostMapping("/registrar")
    public String RegistrarDirecciones(@ModelAttribute("direccion") DireccionesClienteEntity obj) {
        servicio.add(obj);
        return "redirect:/direcciones/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarDirecciones(@ModelAttribute("direccion") DireccionesClienteEntity obj, @PathVariable Integer id) {
        servicio.update(obj, id);
        return "redirect:/direcciones/listar";
    }
    
    @GetMapping("/habilita")
    public String MostrarHabilitarDirecciones(Model modelo) {
        modelo.addAttribute("listardirecciones", servicio.findAll());
        modelo.addAttribute("listarclientes", servicioCli.findAllCustom());
        return "direcciones/habilitardirecciones";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarDirecciones(@PathVariable Integer id) {
        servicio.enable(id);
        return "redirect:/direcciones/habilita";
    }

    @GetMapping("/deshabilitar/{id}")
    public String DeshabilitarDirecciones(@PathVariable Integer id) {
        servicio.delete(id);
        return "redirect:/direcciones/habilita";
    }
}