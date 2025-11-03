package com.peticompvc.bancodehoras.dto;


import java.time.Duration;
import java.time.LocalDate;

public class AtividadeDiariaResponseDTO{
    private long id;
    private Duration horasTotais;
    private LocalDate dataAtividade;
    private String descricao;

    public AtividadeDiariaResponseDTO() {}

    public AtividadeDiariaResponseDTO(String descricao, LocalDate dataAtividade) {
        this.descricao     = descricao;
        this.dataAtividade = dataAtividade;
    }

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Duration getHorasTotais() {
        return horasTotais;
    }

    public long getId() {
        return id;
    }

    public void setHorasTotais(Duration horasTotais) {
        this.horasTotais = horasTotais;
    }

    public void setId(long id) {
        this.id = id;
    }
}
