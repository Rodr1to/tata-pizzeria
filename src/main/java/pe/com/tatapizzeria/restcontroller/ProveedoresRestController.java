package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ProveedoresEntity;
import pe.com.tatapizzeria.service.ProveedoresService;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresRestController {
    @Autowired
    private ProveedoresService s;

    @GetMapping
    public List<ProveedoresEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<ProveedoresEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public ProveedoresEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public ProveedoresEntity add(@RequestBody ProveedoresEntity obj) { return s.add(obj); }

    @PutMapping("/{id}")
    public ProveedoresEntity update(@RequestBody ProveedoresEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public ProveedoresEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public ProveedoresEntity enable(@PathVariable Long id) { return s.enable(id); }
}
