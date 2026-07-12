package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.EmpleadosEntity;
import pe.com.tatapizzeria.service.EmpleadosService;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosRestController {
    @Autowired
    private EmpleadosService s;

    @GetMapping
    public List<EmpleadosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<EmpleadosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public EmpleadosEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public EmpleadosEntity add(@RequestBody EmpleadosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public EmpleadosEntity update(@RequestBody EmpleadosEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public EmpleadosEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public EmpleadosEntity enable(@PathVariable Long id) { return s.enable(id); }
}
