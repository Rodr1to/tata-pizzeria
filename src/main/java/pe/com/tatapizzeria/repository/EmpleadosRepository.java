package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.EmpleadosEntity;
import java.util.List;

public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long> {

    @Query("SELECT s FROM EmpleadosEntity s WHERE s.estado = true")
    List<EmpleadosEntity> findAllCustom();
}
