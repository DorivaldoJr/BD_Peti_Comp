package com.peticompvc.bancodehoras.dto;

import java.time.LocalDate;

public class DescricaoAtividadeDTO {

    private String descricao;
    private LocalDate dataAtividade;

    public DescricaoAtividadeDTO(String descricao, LocalDate dataAtividade) {
        this.descricao      = descricao;
        this.dataAtividade  = dataAtividade;
    }

    public DescricaoAtividadeDTO() {
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }
    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }
}
