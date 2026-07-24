package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;

public interface CombosPromocionesService {
    List<CombosPromocionesEntity> findAll();
    List<CombosPromocionesEntity> findAllCustom();
    CombosPromocionesEntity findById(Integer id);
    CombosPromocionesEntity add(CombosPromocionesEntity obj);
    CombosPromocionesEntity update(CombosPromocionesEntity obj,Integer id);
    CombosPromocionesEntity delete(Integer id);
    CombosPromocionesEntity enable(Integer id);
}
