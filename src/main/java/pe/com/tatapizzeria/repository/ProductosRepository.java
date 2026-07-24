package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.tatapizzeria.entity.ProductosEntity;
import java.util.List;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Integer> {

    @Query("SELECT s FROM ProductosEntity s WHERE s.estado = true")
    List<ProductosEntity> findAllCustom();
}
