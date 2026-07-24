package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.TamanosEntity;

public interface TamanosService {
    List<TamanosEntity> findAll();
    List<TamanosEntity> findAllCustom();
    TamanosEntity findById(Integer id);
    TamanosEntity add(TamanosEntity obj);
    TamanosEntity update(TamanosEntity obj,Integer id);
    TamanosEntity delete(Integer id);
    TamanosEntity enable(Integer id);
}
