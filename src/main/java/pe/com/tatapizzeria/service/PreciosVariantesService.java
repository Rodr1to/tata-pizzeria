package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;

public interface PreciosVariantesService {
    List<PreciosVariantesEntity> findAll();
    List<PreciosVariantesEntity> findAllCustom();
    PreciosVariantesEntity findById(Integer id);
    PreciosVariantesEntity add(PreciosVariantesEntity obj);
    PreciosVariantesEntity update(PreciosVariantesEntity obj,Integer id);
    PreciosVariantesEntity delete(Integer id);
    PreciosVariantesEntity enable(Integer id);
}
