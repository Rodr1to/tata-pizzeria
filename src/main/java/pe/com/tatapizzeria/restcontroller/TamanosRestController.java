package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.TamanosEntity;
import pe.com.tatapizzeria.service.TamanosService;
import java.util.List;

@RestController
@RequestMapping("/api/tamanos")
public class TamanosRestController {
    @Autowired
    private TamanosService s;

    @GetMapping
    public List<TamanosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<TamanosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public TamanosEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public TamanosEntity add(@RequestBody TamanosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public TamanosEntity update(@RequestBody TamanosEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public TamanosEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public TamanosEntity enable(@PathVariable Long id) { return s.enable(id); }
}
