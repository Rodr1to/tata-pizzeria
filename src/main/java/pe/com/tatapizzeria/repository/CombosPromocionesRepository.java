package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.CombosPromocionesEntity;
import java.util.List;

public interface CombosPromocionesRepository extends JpaRepository<CombosPromocionesEntity, Long> {

    @Query("SELECT s FROM CombosPromocionesEntity s WHERE s.estado = true")
    List<CombosPromocionesEntity> findAllCustom();
}
