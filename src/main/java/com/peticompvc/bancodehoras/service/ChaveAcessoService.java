package com.peticompvc.bancodehoras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peticompvc.bancodehoras.repository.ChaveAcessoRepository;
import com.peticompvc.bancodehoras.model.ChaveAcesso;

import java.util.Optional;

@Service
public class ChaveAcessoService {
    private final ChaveAcessoRepository chaveAcessoRepository;

    // Uma classe de exceção customizada
    public static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }
    }

    public ChaveAcessoService(ChaveAcessoRepository chaveAcessoRepository){
        this.chaveAcessoRepository = chaveAcessoRepository;
    }

    public ChaveAcesso buscarEntidadePorChaveAcesso (String codigoRFID){
        Optional<ChaveAcesso> chave = chaveAcessoRepository.findByValorChave(codigoRFID);

        if(chave.isEmpty()){
            throw new BusinessException("O codigo RFID " + codigoRFID + " não esta cadastrado");
        }

        ChaveAcesso chaveAcessoAchada = chave.get();

        return chaveAcessoAchada;
    }
}
