package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ProductosEntity;
import pe.com.tatapizzeria.service.ProductosService;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {
    @Autowired
    private ProductosService s;

    @GetMapping
    public List<ProductosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<ProductosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public ProductosEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public ProductosEntity add(@RequestBody ProductosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public ProductosEntity update(@RequestBody ProductosEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public ProductosEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public ProductosEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
