package com.example.veiculosdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String placa;
    private String tipo;
    private BigDecimal valorMercado;
}
