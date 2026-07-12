package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.SedesEntity;
import pe.com.tatapizzeria.service.SedesService;
import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedesRestController {
    @Autowired
    private SedesService s;

    @GetMapping
    public List<SedesEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<SedesEntity> findAllCustomer() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public SedesEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public SedesEntity add(@RequestBody SedesEntity obj) { return s.add(obj); }

    @PutMapping("/{id}")
    public SedesEntity uupdate(@RequestBody SedesEntity obj, @PathVariable Long id) { return s.update(obj, id); }

    @DeleteMapping("/{id}")
    public SedesEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public SedesEntity enable(@PathVariable Long id) { return s.enable(id); }
}
