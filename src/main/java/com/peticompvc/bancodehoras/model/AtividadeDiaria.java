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
    @Column(name = "id_atividade")
    private long idAtividade;

    @Column (name = "horas_totais")
    private Duration horasTotais;

    @Column (columnDefinition = "TEXT")
    private String descricao;

    @Column (name = "data_atividade", nullable = false)
    private LocalDate dataAtividade;

    @ManyToOne
    @JoinColumn (name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    public AtividadeDiaria() {}

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public void setHorasTotais(Duration horasTotais) {
        this.horasTotais = horasTotais;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdAtividade(long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Duration getHorasTotais() {
        return horasTotais;
    }

    public long getIdAtividade() {
        return idAtividade;
    }
}