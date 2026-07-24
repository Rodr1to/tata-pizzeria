package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.EmpleadosEntity;

public interface EmpleadosService {
    List<EmpleadosEntity> findAll();
    List<EmpleadosEntity> findAllCustom();
    EmpleadosEntity findById(Integer id);
    EmpleadosEntity add(EmpleadosEntity obj);
    EmpleadosEntity update(EmpleadosEntity obj,Integer id);
    EmpleadosEntity delete(Integer id);
    EmpleadosEntity enable(Integer id);
}
