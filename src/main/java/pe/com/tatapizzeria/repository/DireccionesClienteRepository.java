package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;
import java.util.List;

public interface DireccionesClienteRepository extends JpaRepository<DireccionesClienteEntity, Long> {

    @Query("SELECT s FROM DireccionesClienteEntity s WHERE s.estado = true")
    List<DireccionesClienteEntity> findAllCustom();
}
