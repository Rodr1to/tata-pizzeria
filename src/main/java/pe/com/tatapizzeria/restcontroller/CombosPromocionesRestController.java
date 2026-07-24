package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;
import pe.com.tatapizzeria.service.CombosPromocionesService;
import java.util.List;

@RestController
@RequestMapping("/api/combos")
public class CombosPromocionesRestController {
    @Autowired
    private CombosPromocionesService s;

    @GetMapping
    public List<CombosPromocionesEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<CombosPromocionesEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public CombosPromocionesEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public CombosPromocionesEntity add(@RequestBody CombosPromocionesEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public CombosPromocionesEntity update(@RequestBody CombosPromocionesEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public CombosPromocionesEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public CombosPromocionesEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
