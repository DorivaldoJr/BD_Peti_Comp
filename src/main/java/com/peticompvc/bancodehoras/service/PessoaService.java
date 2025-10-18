package com.peticompvc.bancodehoras.service;

import com.peticompvc.bancodehoras.model.Pessoa;
import com.peticompvc.bancodehoras.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    PessoaDTOResponse savePerson(PessoaDTO pessoa){

        // transforma pessoa dto em pessoa(entidade)
        if(pessoa == null){
            throw new Exception("Peson cannot be null");
        }
        repository.save(pessoa); // salva a entidade

        // transforma no dto de resposta e retorna
        return  pessoa;
    }
}
