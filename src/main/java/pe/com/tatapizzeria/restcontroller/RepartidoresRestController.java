package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.RepartidoresEntity;
import pe.com.tatapizzeria.service.RepartidoresService;
import java.util.List;

@RestController
@RequestMapping("/api/repartidores")
public class RepartidoresRestController {
    @Autowired
    private RepartidoresService s;

    @GetMapping
    public List<RepartidoresEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<RepartidoresEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public RepartidoresEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public RepartidoresEntity add(@RequestBody RepartidoresEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public RepartidoresEntity update(@RequestBody RepartidoresEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public RepartidoresEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public RepartidoresEntity enable(@PathVariable Long id) { return s.enable(id); }
}
