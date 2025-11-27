package com.peticompvc.bancodehoras.service;

import com.peticompvc.bancodehoras.model.AtividadeDiaria;
import com.peticompvc.bancodehoras.model.Pessoa;
import com.peticompvc.bancodehoras.dto.DescricaoAtividadeDTO;
import org.springframework.stereotype.Service;
import com.peticompvc.bancodehoras.repository.AtividadeDiariaRepository;
import com.peticompvc.bancodehoras.repository.RegistroPontoRepository;
import com.peticompvc.bancodehoras.service.PessoaService;

import java.util.Optional;

@Service
public class AtividadeDiariaService {
    private final AtividadeDiariaRepository atividadeDiariaRepository;
    private final PessoaService pessoaService;

    // Injeção de Dependência
    public AtividadeDiariaService(AtividadeDiariaRepository atividadeDiariaRepository,
                                  PessoaService pessoaService) {
        this.atividadeDiariaRepository = atividadeDiariaRepository;
        this.pessoaService = pessoaService;
    }
    public AtividadeDiaria atualizarDescricao(Integer matricula, DescricaoAtividadeDTO dto) {


        Pessoa pessoa = pessoaService.buscarPessoaPorMatricula(matricula);


        Optional<AtividadeDiaria> caixaAtividade = atividadeDiariaRepository
                .findByPessoaAndDataAtividade(pessoa, dto.getDataAtividade());


        AtividadeDiaria atividadeAlvo = null;

        if (caixaAtividade.isEmpty()) {

        } else {
            atividadeAlvo = new AtividadeDiaria();
            atividadeAlvo.setPessoa(pessoa);                // Dona da atividade
            atividadeAlvo.setDataAtividade(dto.getDataAtividade()); // Data da atividade
            // (O ID e as Horas Totais começam nulos ou zero automaticamente)

            atividadeAlvo = caixaAtividade.get();
        }

        atividadeAlvo.setDescricao(dto.getDescricao());

        return atividadeDiariaRepository.save(atividadeAlvo);
    }
}
