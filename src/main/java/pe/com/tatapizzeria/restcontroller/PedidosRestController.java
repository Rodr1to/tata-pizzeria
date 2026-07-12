package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.PedidosEntity;
import pe.com.tatapizzeria.service.PedidosService;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRestController {
    @Autowired
    private PedidosService s;

    @GetMapping
    public List<PedidosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<PedidosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public PedidosEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public PedidosEntity add(@RequestBody PedidosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public PedidosEntity update(@RequestBody PedidosEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public PedidosEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public PedidosEntity enable(@PathVariable Long id) { return s.enable(id); }
}