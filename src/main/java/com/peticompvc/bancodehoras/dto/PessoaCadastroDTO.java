package com.peticompvc.bancodehoras.dto;

public class PessoaCadastroDTO {

    private String nome;
    private String email;
    private int matricula;
    private String funcao;

    public PessoaCadastroDTO() {
    }

    public PessoaCadastroDTO(String nome, String email, int matricula, String funcao) {
        this.nome      = nome;
        this.email     = email;
        this.funcao    = funcao;
        this.matricula = matricula;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
