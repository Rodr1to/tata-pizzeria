package pe.com.tatapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.tatapizzeria.entity.DireccionesClienteEntity;
import java.util.List;

@Repository
public interface DireccionesClienteRepository extends JpaRepository<DireccionesClienteEntity, Integer> {

    @Query("SELECT d FROM DireccionesClienteEntity d WHERE d.estado = true")
    List<DireccionesClienteEntity> findAllCustom();

    //  Buscar direcciones por cliente
    @Query("SELECT d FROM DireccionesClienteEntity d WHERE d.cliente.id = ?1 AND d.estado = true")
    List<DireccionesClienteEntity> findByClienteId(Integer idCliente);
    
    // Buscar todas las direcciones de un cliente (incluyendo inactivas)
    @Query("SELECT d FROM DireccionesClienteEntity d WHERE d.cliente.id = ?1")
    List<DireccionesClienteEntity> findAllByClienteId(Integer idCliente);
}