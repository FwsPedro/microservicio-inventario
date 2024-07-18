package com.microservicio.inventario.dao;

import com.microservicio.inventario.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}