package com.peticompvc.bancodehoras.model;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "registro_ponto")

/*
id_registro SERIAL PRIMARY KEY,
id_pessoa INTEGER NOT NULL REFERENCES PESSOA(id_pessoa) ON DELETE RESTRICT,
id_chave INTEGER NOT NULL REFERENCES CHAVE_ACESSO(id_chave) ON DELETE RESTRICT,
data_registro TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
tipo VARCHAR(20) CHECK ( tipo IN ('ENTRADA','SAIDA')) NOT NULL
*/
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private long idRegistro;

    @Column(length = 20, nullable = false)
    private String tipo;

    @Column (name = "data_registro", nullable = false)
    private Instant dataRegistro;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_chave", nullable = false)
    private ChaveAcesso chaveAcesso;

    public RegistroPonto() {}

    public void setChaveAcesso(ChaveAcesso chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setDataRegistro(Instant dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdRegistro(long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public ChaveAcesso getChaveAcesso() {
        return chaveAcesso;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Instant getDataRegistro() {
        return dataRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public long getIdRegistro() {
        return idRegistro;
    }
}