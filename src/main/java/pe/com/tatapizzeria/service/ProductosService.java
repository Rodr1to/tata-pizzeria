package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.ProductosEntity;

public interface ProductosService {
    List<ProductosEntity> findAll();
    List<ProductosEntity> findAllCustom();
    ProductosEntity findById(Integer id);
    ProductosEntity add(ProductosEntity obj);
    ProductosEntity update(ProductosEntity obj,Integer id);
    ProductosEntity delete(Integer id);
    ProductosEntity enable(Integer id);
}