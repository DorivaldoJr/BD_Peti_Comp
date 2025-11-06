package com.peticompvc.bancodehoras.service;

import com.peticompvc.bancodehoras.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peticompvc.bancodehoras.model.Pessoa;
import java.util.Optional;
import com.peticompvc.bancodehoras.dto.PessoaCadastroDTO;
import com.peticompvc.bancodehoras.dto.PessoaResponseDTO;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    // Uma classe de exceção customizada
    public static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }
    }

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa criarNovaPessoa(PessoaCadastroDTO dto) {

        // Verificacao - Email é unique no banco de dados
        Optional<Pessoa> pessoaPorEmail = pessoaRepository.findByEmail(dto.getEmail());
        if (pessoaPorEmail.isPresent()){
            throw new BusinessException("O email já foi cadastrado!");
        }

        // Verificacao - Matrícula é unique no banco de dados
        Optional<Pessoa> pessoaPorMatricula = pessoaRepository.findByMatricula(dto.getMatricula());
        if(pessoaPorMatricula.isPresent()){
            throw new BusinessException("A matrícula ja foi cadastrada");
        }


        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(dto.getNome());
        novaPessoa.setEmail(dto.getEmail());
        novaPessoa.setMatricula(dto.getMatricula());
        novaPessoa.setFuncao(dto.getFuncao());
        novaPessoa.setStatusAtivo(true); // Default ativo para nova pessoa

        return pessoaRepository.save(novaPessoa);
    }

    public Pessoa buscarPessoaPorMatricula(Integer matricula){
        Optional<Pessoa> pessoa = pessoaRepository.findByMatricula(matricula);

        if (pessoa.isEmpty()){
            throw new BusinessException("A pessoa com a matricula " + matricula + " não foi encontrada");
        }

        Pessoa pessoaEncontrada = pessoa.get();
        return pessoaEncontrada;
    }

    public PessoaResponseDTO buscarPessoaResponsePorMatricula(Integer matricula){

        Pessoa pessoa = buscarPessoaPorMatricula(matricula);
        PessoaResponseDTO pessoaDTO = new PessoaResponseDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setId(pessoa.getId_pessoa());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setStatusAtivo(pessoa.getStatusAtivo());
        pessoaDTO.setFuncao(pessoa.getFuncao());
        pessoaDTO.setMatricula(pessoa.getMatricula());
        return pessoaDTO;
    }
}
