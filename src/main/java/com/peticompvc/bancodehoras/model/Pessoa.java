package com.peticompvc.bancodehoras.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "pessoa")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private long idPessoa;

    @Column(length = 70, nullable = false)
    private String nome;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private Integer matricula;

    @Column(length = 20, nullable = false)
    private String funcao;

    @Column(name = "status_ativo", nullable = false)
    private Boolean statusAtivo;

    @OneToMany(mappedBy = "pessoa")
    private List<AtividadeDiaria> atividades;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private ChaveAcesso chaveAcesso;

    @OneToMany(mappedBy = "pessoa")
    private List<RegistroPonto> registrosPonto;

    public long getId_pessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }

    public Boolean getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(Boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }


}
