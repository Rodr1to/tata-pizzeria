package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;
import pe.com.tatapizzeria.service.CategoriasProductoService;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasProductoRestController {
    @Autowired
    private CategoriasProductoService s;

    @GetMapping
    public List<CategoriasProductoEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<CategoriasProductoEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public CategoriasProductoEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public CategoriasProductoEntity add(@RequestBody CategoriasProductoEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public CategoriasProductoEntity update(@RequestBody CategoriasProductoEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public CategoriasProductoEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public CategoriasProductoEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
