package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.ClientesEntity;
import pe.com.tatapizzeria.service.ClientesService;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesRestController {
    @Autowired
    private ClientesService s;

    @GetMapping
    public List<ClientesEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<ClientesEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public ClientesEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public ClientesEntity add(@RequestBody ClientesEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public ClientesEntity update(@RequestBody ClientesEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public ClientesEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public ClientesEntity enable(@PathVariable Long id) { return s.enable(id); }
}
