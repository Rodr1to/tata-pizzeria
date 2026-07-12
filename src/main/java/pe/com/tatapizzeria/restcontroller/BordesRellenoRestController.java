package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;
import pe.com.tatapizzeria.service.BordesRellenoService;
import java.util.List;

@RestController
@RequestMapping("/api/bordes")
public class BordesRellenoRestController {
    @Autowired
    private BordesRellenoService s;

    @GetMapping
    public List<BordesRellenoEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<BordesRellenoEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public BordesRellenoEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public BordesRellenoEntity add(@RequestBody BordesRellenoEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public BordesRellenoEntity update(@RequestBody BordesRellenoEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public BordesRellenoEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public BordesRellenoEntity enable(@PathVariable Long id) { return s.enable(id); }
}
