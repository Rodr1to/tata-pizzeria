package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.CategoriasProductoEntity;
import java.util.List;

public interface CategoriasProductoRepository extends JpaRepository<CategoriasProductoEntity, Integer> {

    @Query("SELECT s FROM CategoriasProductoEntity s WHERE s.estado = true")
    List<CategoriasProductoEntity> findAllCustom();
}
