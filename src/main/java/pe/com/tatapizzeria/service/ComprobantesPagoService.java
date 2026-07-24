package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;

public interface ComprobantesPagoService {
    List<ComprobantesPagoEntity> findAll();
    List<ComprobantesPagoEntity> findAllCustom();
    ComprobantesPagoEntity findById(Integer id);
    ComprobantesPagoEntity add(ComprobantesPagoEntity obj);
    ComprobantesPagoEntity update(ComprobantesPagoEntity obj,Integer id);
    ComprobantesPagoEntity delete(Integer id);
    ComprobantesPagoEntity enable(Integer id);
}
