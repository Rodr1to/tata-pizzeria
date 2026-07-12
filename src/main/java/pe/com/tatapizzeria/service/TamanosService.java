package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.TamanosEntity;

public interface TamanosService {
    List<TamanosEntity> findAll();
    List<TamanosEntity> findAllCustom();
    TamanosEntity findById(Long id);
    TamanosEntity add(TamanosEntity obj);
    TamanosEntity update(TamanosEntity obj, Long id);
    TamanosEntity delete(Long id);
    TamanosEntity enable(Long id);
}
