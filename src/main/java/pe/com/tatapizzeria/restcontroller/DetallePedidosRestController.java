package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.DetallePedidosEntity;
import pe.com.tatapizzeria.service.DetallePedidosService;
import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidosRestController {
    @Autowired
    private DetallePedidosService s;

    @GetMapping
    public List<DetallePedidosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<DetallePedidosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public DetallePedidosEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public DetallePedidosEntity add(@RequestBody DetallePedidosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public DetallePedidosEntity update(@RequestBody DetallePedidosEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public DetallePedidosEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public DetallePedidosEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
