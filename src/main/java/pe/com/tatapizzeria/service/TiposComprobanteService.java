package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.TiposComprobanteEntity;

public interface TiposComprobanteService {
    List<TiposComprobanteEntity> findAll();
    List<TiposComprobanteEntity> findAllCustom();
    TiposComprobanteEntity findById(Long id);
    TiposComprobanteEntity add(TiposComprobanteEntity obj);
    TiposComprobanteEntity update(TiposComprobanteEntity obj, Long id);
    TiposComprobanteEntity delete(Long id);
    TiposComprobanteEntity enable(Long id);
}
