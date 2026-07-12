package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;

public interface CombosPromocionesService {
    List<CombosPromocionesEntity> findAll();
    List<CombosPromocionesEntity> findAllCustom();
    CombosPromocionesEntity findById(Long id);
    CombosPromocionesEntity add(CombosPromocionesEntity obj);
    CombosPromocionesEntity update(CombosPromocionesEntity obj, Long id);
    CombosPromocionesEntity delete(Long id);
    CombosPromocionesEntity enable(Long id);
}
