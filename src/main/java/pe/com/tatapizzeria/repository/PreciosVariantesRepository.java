package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.PreciosVariantesEntity;
import java.util.List;

public interface PreciosVariantesRepository extends JpaRepository<PreciosVariantesEntity, Integer> {

    @Query("SELECT s FROM PreciosVariantesEntity s WHERE s.estado = true")
    List<PreciosVariantesEntity> findAllCustom();
}
