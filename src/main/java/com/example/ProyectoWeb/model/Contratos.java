package com.example.ProyectoWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "contratos")
public class Contratos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String identificador;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "nombre_contratante", length = 255)
    private String nombreContratante;

    @Column(name = "documento_contratante", length = 255)
    private String documentoContratante;

    @Column(name = "nombre_contratantista", length = 255)
    private String nombreContratantista;

    @Column(name = "documento_contratantista", length = 255)
    private String documentoContratantista;

    @Column(name = "fecha_inicial", nullable = false)
    private LocalDateTime fechaInicial;

    @Column(name = "fecha_final", nullable = false)
    private LocalDateTime fechaFinal;
}
