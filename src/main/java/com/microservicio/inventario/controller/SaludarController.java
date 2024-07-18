package com.microservicio.inventario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludarController {
    @GetMapping(value="/saludar")
    public ResponseEntity<String> saludar(){
        return new ResponseEntity<>("Hola Microservicio", HttpStatus.OK);
    }
}