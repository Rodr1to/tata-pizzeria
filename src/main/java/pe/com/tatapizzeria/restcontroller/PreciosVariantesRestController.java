package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;
import pe.com.tatapizzeria.service.PreciosVariantesService;
import java.util.List;

@RestController
@RequestMapping("/api/variantes")
public class PreciosVariantesRestController {
    @Autowired
    private PreciosVariantesService s;

    @GetMapping
    public List<PreciosVariantesEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<PreciosVariantesEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public PreciosVariantesEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public PreciosVariantesEntity add(@RequestBody PreciosVariantesEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public PreciosVariantesEntity update(@RequestBody PreciosVariantesEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public PreciosVariantesEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public PreciosVariantesEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
