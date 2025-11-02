package com.peticompvc.bancodehoras.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chave_acesso")

public class ChaveAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_chave")
    private long idChave;

    @Column(name = "valor_chave", length = 100, unique = true, nullable = false)
    private String valorChave;

    @Column(name= "data_ativacao", nullable = false)
    private java.time.LocalDate dataAtivacao;

    @OneToOne
    @JoinColumn(name = "id_pessoa", unique = true, referencedColumnName = "id_pessoa")
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public String getValorChave() {
        return valorChave;
    }

    public void setValorChave(String valorChave) {
        this.valorChave = valorChave;
    }

    public long getIdChave() {
        return idChave;
    }

    public void setIdChave(long idChave) {
        this.idChave = idChave;
    }
}
