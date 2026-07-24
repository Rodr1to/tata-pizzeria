package pe.com.tatapizzeria.service;

import pe.com.tatapizzeria.entity.SedesEntity;
import java.util.List;

public interface SedesService {
    List<SedesEntity> findAll();
    List<SedesEntity> findAllCustom();
    SedesEntity findById(Integer id);
    SedesEntity add(SedesEntity obj);
    SedesEntity update(SedesEntity obj,Integer id);
    SedesEntity delete(Integer id);
    SedesEntity enable(Integer id);
}
