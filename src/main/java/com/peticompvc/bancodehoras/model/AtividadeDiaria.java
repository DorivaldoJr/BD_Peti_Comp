package com.peticompvc.bancodehoras.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.Duration;

@Entity
@Table(name = "atividade_diaria")

public class AtividadeDiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_atividade;

    @Column (name = "horas_totais")
    private Duration horasTotais;

    @Column (columnDefinition = "TEXT")
    private String descricao;

    @Column (name = "data_atividade", nullable = false)
    private LocalDate dataAtividade;

    @ManyToOne
    @JoinColumn (name = "id_pessoa", nullable = false)
    private Pessoa pessoa;
}