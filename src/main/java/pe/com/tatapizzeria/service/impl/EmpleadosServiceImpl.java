package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.EmpleadosEntity;
import pe.com.tatapizzeria.repository.EmpleadosRepository;
import pe.com.tatapizzeria.service.EmpleadosService;
import java.util.List;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosRepository repositorio;

    @Override
    public List<EmpleadosEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<EmpleadosEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public EmpleadosEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public EmpleadosEntity add(EmpleadosEntity obj) { return repositorio.save(obj); }

    @Override
    public EmpleadosEntity update(EmpleadosEntity obj, Long id) {
        EmpleadosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            BeanUtils.copyProperties(obj, actual, "codigo");
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public EmpleadosEntity delete(Long id) {
        EmpleadosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(false);
            return repositorio.save(actual);
        }
        return null;
    }

    @Override
    public EmpleadosEntity enable(Long id) {
        EmpleadosEntity actual = repositorio.findById(id).orElse(null);
        if (actual != null) {
            actual.setEstado(true);
            return repositorio.save(actual);
        }
        return null;
    }
}
