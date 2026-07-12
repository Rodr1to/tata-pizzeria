package pe.com.tatapizzeria.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.tatapizzeria.entity.UsuariosEntity;
import pe.com.tatapizzeria.service.UsuariosService;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {
    @Autowired
    private UsuariosService s;

    @GetMapping
    public List<UsuariosEntity> findAll() { return s.findAll(); }

    @GetMapping("/custom")
    public List<UsuariosEntity> findAllCustom() { return s.findAllCustom(); }

    @GetMapping("/{id}")
    public UsuariosEntity findById(@PathVariable Long id) { return s.findById(id); }

    @PostMapping
    public UsuariosEntity add(@RequestBody UsuariosEntity o) { return s.add(o); }

    @PutMapping("/{id}")
    public UsuariosEntity update(@RequestBody UsuariosEntity o, @PathVariable Long id) { return s.update(o, id); }

    @DeleteMapping("/{id}")
    public UsuariosEntity delete(@PathVariable Long id) { return s.delete(id); }

    @PatchMapping("/{id}")
    public UsuariosEntity enable(@PathVariable Long id) { return s.enable(id); }
}
