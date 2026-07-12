package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.EmpleadosEntity;

public interface EmpleadosService {
    List<EmpleadosEntity> findAll();
    List<EmpleadosEntity> findAllCustom();
    EmpleadosEntity findById(Long id);
    EmpleadosEntity add(EmpleadosEntity obj);
    EmpleadosEntity update(EmpleadosEntity obj, Long id);
    EmpleadosEntity delete(Long id);
    EmpleadosEntity enable(Long id);
}
