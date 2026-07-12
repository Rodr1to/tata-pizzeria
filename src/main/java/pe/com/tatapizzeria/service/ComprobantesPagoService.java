package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ComprobantesPagoEntity;

public interface ComprobantesPagoService {
    List<ComprobantesPagoEntity> findAll();
    List<ComprobantesPagoEntity> findAllCustom();
    ComprobantesPagoEntity findById(Long id);
    ComprobantesPagoEntity add(ComprobantesPagoEntity obj);
    ComprobantesPagoEntity update(ComprobantesPagoEntity obj, Long id);
    ComprobantesPagoEntity delete(Long id);
    ComprobantesPagoEntity enable(Long id);
}
