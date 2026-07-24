package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;
import pe.com.tatapizzeria.service.ComprobantesPagoService;
import java.util.List;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobantesPagoRestController {
    @Autowired
    private ComprobantesPagoService s;

    @GetMapping
    public List<ComprobantesPagoEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<ComprobantesPagoEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public ComprobantesPagoEntity findById(@PathVariable Integer id) { return s.findById(id); }

    @PostMapping
    public ComprobantesPagoEntity add(@RequestBody ComprobantesPagoEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public ComprobantesPagoEntity update(@RequestBody ComprobantesPagoEntity o, @PathVariable Integer id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public ComprobantesPagoEntity delete(@PathVariable Integer id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public ComprobantesPagoEntity enable(@PathVariable Integer id) { return s.enable(id); }
}
