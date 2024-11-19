package com.example.ProyectoWeb.prueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProyectoWeb.dto.ContratoDTO;
import com.example.ProyectoWeb.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;


    @PostMapping
    public ResponseEntity<ContratoDTO> crearContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO nuevoContrato = contratoService.crearContrato(contratoDTO);
        return new ResponseEntity<>(nuevoContrato, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Integer id, @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO contratoActualizado = contratoService.actualizarContrato(id, contratoDTO);
        return ResponseEntity.ok(contratoActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Integer id) {
        contratoService.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<ContratoDTO>> listarContratos() {
        List<ContratoDTO> contratos = contratoService.listarContratos();
        return ResponseEntity.ok(contratos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerContratoPorId(@PathVariable Integer id) {
        ContratoDTO contrato = contratoService.obtenerContratoPorId(id);
        return ResponseEntity.ok(contrato);
    }
}