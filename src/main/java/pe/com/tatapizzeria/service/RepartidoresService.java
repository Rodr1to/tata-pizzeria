package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.RepartidoresEntity;

public interface RepartidoresService {
    List<RepartidoresEntity> findAll();
    List<RepartidoresEntity> findAllCustom();
    RepartidoresEntity findById(Integer id);
    RepartidoresEntity add(RepartidoresEntity obj);
    RepartidoresEntity update(RepartidoresEntity obj,Integer id);
    RepartidoresEntity delete(Integer id);
    RepartidoresEntity enable(Integer id);
}
