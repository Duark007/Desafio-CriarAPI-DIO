package com.duark.desafio_criarapi_dio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consumption_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private ActivityType atividade;

    private Double quantidade;
    private LocalDateTime data;
    private Double totalCarbonoGerado; // Calculado: quantidade * fatorEmissao
}