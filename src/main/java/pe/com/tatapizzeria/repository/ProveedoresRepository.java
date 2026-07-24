package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.ProveedoresEntity;
import java.util.List;

public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Integer> {

    @Query("SELECT s FROM ProveedoresEntity s WHERE s.estado = true")
    List<ProveedoresEntity> findAllCustom();
}
