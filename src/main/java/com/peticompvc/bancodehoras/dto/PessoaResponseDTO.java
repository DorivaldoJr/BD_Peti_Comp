package com.peticompvc.bancodehoras.dto;

public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private int matricula;
    private String funcao;
    private boolean statusAtivo;

    public PessoaResponseDTO() {}

    public PessoaResponseDTO(Long id, String nome, String email, int matricula, String funcao, boolean statusAtivo) {
        this.email       = email;
        this.funcao      = funcao;
        this.matricula   = matricula;
        this.statusAtivo = statusAtivo;
        this.nome        = nome;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
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

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
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

    public Long getId() {
        return id;
    }
}
