package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.ClientesEntity;
import java.util.List;

public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer> {

    @Query("SELECT s FROM ClientesEntity s WHERE s.estado = true")
    List<ClientesEntity> findAllCustom();
}
