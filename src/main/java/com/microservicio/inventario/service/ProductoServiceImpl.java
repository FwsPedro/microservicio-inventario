package com.microservicio.inventario.service;

import com.microservicio.inventario.dao.ProductoRepository;
import com.microservicio.inventario.dto.ProductoDTO;
import com.microservicio.inventario.model.ProductoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public void crear(ProductoDTO productoDTO) {
        ProductoEntity productoEntityNew = new ProductoEntity();
        productoEntityNew.setNombre(productoDTO.getNombre());
        productoEntityNew.setCantidad(productoDTO.getCantidad());
        productoRepository.save(productoEntityNew);
    }

    @Override
    public List<ProductoDTO> consultarTodos() {
        return productoRepository.findAll().stream().map(this::mapearProducto).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> consultarPorDisponibilidadEnInventario() {
        return null;
    }

    @Override
    @Transactional
    public Integer guardar(ProductoDTO productoDTO) {
        Integer codigo = this.guardarProducto(productoDTO);
        this.lanzarExcepcion();
        return codigo;
    }

    private Integer guardarProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setCodigo(productoDTO.getCodigo());
        productoEntity.setNombre(productoDTO.getNombre());
        productoEntity.setCantidad(productoDTO.getCantidad());
        return productoRepository.save(productoEntity).getCodigo();
    }

    private void lanzarExcepcion(){
        throw new ResponseStatusException(HttpStatus.CONFLICT, "error lanzada");
    }

    private ProductoDTO mapearProducto(ProductoEntity d){
        return new ProductoDTO(d.getCodigo(), d.getNombre(), d.getCantidad());
    }
}