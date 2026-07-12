package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.UsuariosEntity;
import java.util.List;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {

    @Query("SELECT s FROM UsuariosEntity s WHERE s.estado = true")
    List<UsuariosEntity> findAllCustom();
}
