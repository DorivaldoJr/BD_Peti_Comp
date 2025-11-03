package com.peticompvc.bancodehoras.dto;

public class BatidaPontoDTO {

    private String codigoRFID;
    private String tipo;

    public String getCodigoRFID(){
        return this.codigoRFID;
    }

    public void setCodigoRFID(String codigoRFID){
        this.codigoRFID = codigoRFID;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public BatidaPontoDTO(String codigoRFID, String tipo) {
        this.codigoRFID = codigoRFID;
        this.tipo       = tipo;
    }

    public BatidaPontoDTO() {
    }
}
