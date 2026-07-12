package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;

public interface PreciosVariantesService {
    List<PreciosVariantesEntity> findAll();
    List<PreciosVariantesEntity> findAllCustom();
    PreciosVariantesEntity findById(Long id);
    PreciosVariantesEntity add(PreciosVariantesEntity obj);
    PreciosVariantesEntity update(PreciosVariantesEntity obj, Long id);
    PreciosVariantesEntity delete(Long id);
    PreciosVariantesEntity enable(Long id);
}
