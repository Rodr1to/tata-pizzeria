package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialEstadosPedidoRestController {
    @Autowired
    private HistorialEstadosPedidoService s;

    @GetMapping
    public List<HistorialEstadosPedidoEntity> findAll() { return s.findAll(); }

    @GetMapping("/{id}")
    public HistorialEstadosPedidoEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public HistorialEstadosPedidoEntity add(@RequestBody HistorialEstadosPedidoEntity o) { return s.add(o); }
}
