package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.RepartidoresEntity;

public interface RepartidoresService {
    List<RepartidoresEntity> findAll();
    List<RepartidoresEntity> findAllCustom();
    RepartidoresEntity findById(Long id);
    RepartidoresEntity add(RepartidoresEntity obj);
    RepartidoresEntity update(RepartidoresEntity obj, Long id);
    RepartidoresEntity delete(Long id);
    RepartidoresEntity enable(Long id);
}
