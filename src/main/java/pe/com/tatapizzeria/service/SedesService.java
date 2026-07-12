package pe.com.tatapizzeria.service;

import pe.com.tatapizzeria.entity.SedesEntity;
import java.util.List;

public interface SedesService {
    List<SedesEntity> findAll();
    List<SedesEntity> findAllCustom();
    SedesEntity findById(Long id);
    SedesEntity add(SedesEntity obj);
    SedesEntity update(SedesEntity obj, Long id);
    SedesEntity delete(Long id);
    SedesEntity enable(Long id);
}
