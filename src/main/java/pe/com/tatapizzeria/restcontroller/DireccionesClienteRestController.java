package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;
import pe.com.tatapizzeria.service.DireccionesClienteService;
import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionesClienteRestController {
    @Autowired
    private DireccionesClienteService s;

    @GetMapping
    public List<DireccionesClienteEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<DireccionesClienteEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public DireccionesClienteEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public DireccionesClienteEntity add(@RequestBody DireccionesClienteEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public DireccionesClienteEntity update(@RequestBody DireccionesClienteEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public DireccionesClienteEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public DireccionesClienteEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
