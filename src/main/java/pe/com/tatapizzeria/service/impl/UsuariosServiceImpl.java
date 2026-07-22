package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.UsuariosEntity;
import pe.com.tatapizzeria.repository.UsuariosRepository;
import pe.com.tatapizzeria.service.UsuariosService;
import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository repositorio;

    @Override
    public List<UsuariosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<UsuariosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public UsuariosEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public UsuariosEntity add(UsuariosEntity obj) { return repositorio.save(obj); }

    @Override
    public UsuariosEntity update(UsuariosEntity obj, Long id) {
        UsuariosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "id", "fechaRegistro");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public UsuariosEntity delete(Long id) {
        UsuariosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public UsuariosEntity enable(Long id) {
        UsuariosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}