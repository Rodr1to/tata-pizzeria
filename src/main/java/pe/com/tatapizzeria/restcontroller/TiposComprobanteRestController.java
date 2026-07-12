package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;
import pe.com.tatapizzeria.service.TiposComprobanteService;
import java.util.List;

@RestController
@RequestMapping("/api/tiposcomprobante")
public class TiposComprobanteRestController {
    @Autowired
    private TiposComprobanteService s;

    @GetMapping
    public List<TiposComprobanteEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<TiposComprobanteEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public TiposComprobanteEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public TiposComprobanteEntity add(@RequestBody TiposComprobanteEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public TiposComprobanteEntity update(@RequestBody TiposComprobanteEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public TiposComprobanteEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public TiposComprobanteEntity enable(@PathVariable Long id) { return s.enable(id); }
}
