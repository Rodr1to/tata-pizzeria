package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;

public interface TiposComprobanteService {
    List<TiposComprobanteEntity> findAll();
    List<TiposComprobanteEntity> findAllCustom();
    TiposComprobanteEntity findById(Integer id);
    TiposComprobanteEntity add(TiposComprobanteEntity obj);
    TiposComprobanteEntity update(TiposComprobanteEntity obj,Integer id);
    TiposComprobanteEntity delete(Integer id);
    TiposComprobanteEntity enable(Integer id);
}
