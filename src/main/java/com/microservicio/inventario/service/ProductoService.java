package com.microservicio.inventario.service;

import com.microservicio.inventario.dto.ProductoDTO;
import com.microservicio.inventario.model.ProductoEntity;

import java.util.List;

public interface ProductoService {
    void crear(ProductoDTO productoDTO);
    List<ProductoDTO> consultarTodos();
    List<ProductoDTO> consultarPorDisponibilidadEnInventario();
    Integer guardar(ProductoDTO productoDTO);
}
