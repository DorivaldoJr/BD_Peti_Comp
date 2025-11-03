package com.peticompvc.bancodehoras.dto;

import java.time.Instant;

public class RegistroPontoResponseDTO {

    private String tipo;
    private Instant dataRegistro;
    private long id;

    public RegistroPontoResponseDTO(String tipoRegistro, Instant dataRegistro, long id ) {
        this.dataRegistro         = dataRegistro;
        this.tipo = tipo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataRegistro(Instant dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public long getId() {
        return id;
    }

    public Instant getDataRegistro() {
        return dataRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public RegistroPontoResponseDTO() {}

    public Instant getData() {
        return dataRegistro;
    }

    public String getTipoR() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
