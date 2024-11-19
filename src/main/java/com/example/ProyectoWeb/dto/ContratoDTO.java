package com.example.ProyectoWeb.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {

    private Integer id;
    private String identificador;
    private BigDecimal precio;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratantista;
    private String documentoContratantista;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
}
