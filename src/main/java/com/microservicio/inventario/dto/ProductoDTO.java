package com.microservicio.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7167762692330801803L;

    private Integer codigo;
    private String nombre;
    private Integer cantidad;
}