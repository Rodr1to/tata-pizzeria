package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ProductosEntity;

public interface ProductosService {
    List<ProductosEntity> findAll();
    List<ProductosEntity> findAllCustom();
    ProductosEntity findById(Long id);
    ProductosEntity add(ProductosEntity obj);
    ProductosEntity update(ProductosEntity obj, Long id);
    ProductosEntity delete(Long id);
    ProductosEntity enable(Long id);
}