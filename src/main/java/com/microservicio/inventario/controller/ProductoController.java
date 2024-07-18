package com.microservicio.inventario.controller;

import com.microservicio.inventario.dto.ProductoDTO;
import com.microservicio.inventario.service.ProductoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostConstruct
    public void crearProductos(){
        ProductoDTO productoDTO = new ProductoDTO(null, "Mesa", 0);
        productoService.crear(productoDTO);
    }

    @Operation(summary = "productos", description = "Listado productos disponibles para venta")
    @GetMapping("/")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosDisponibles() {
        return new ResponseEntity<>(productoService.consultarPorDisponibilidadEnInventario(), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Integer> actualizarInventario(
            @Parameter(description="Informacion de productos para actualizar inventario")
            @RequestBody ProductoDTO productoDTO) {
        return new ResponseEntity<>(productoService.guardar(productoDTO), HttpStatus.OK);
    }
}
