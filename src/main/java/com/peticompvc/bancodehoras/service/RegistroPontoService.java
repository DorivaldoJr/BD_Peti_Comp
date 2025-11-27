package com.peticompvc.bancodehoras.service;

import com.peticompvc.bancodehoras.dto.BatidaPontoDTO;
import com.peticompvc.bancodehoras.dto.RegistroPontoResponseDTO;
import com.peticompvc.bancodehoras.model.ChaveAcesso;
import com.peticompvc.bancodehoras.model.RegistroPonto;
import org.springframework.stereotype.Service;
import com.peticompvc.bancodehoras.service.ChaveAcessoService;
import com.peticompvc.bancodehoras.service.PessoaService;
import com.peticompvc.bancodehoras.repository.PessoaRepository;
import com.peticompvc.bancodehoras.repository.RegistroPontoRepository;
import com.peticompvc.bancodehoras.repository.AtividadeDiariaRepository;
import com.peticompvc.bancodehoras.model.Pessoa;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistroPontoService {

    private final ChaveAcessoService chaveAcessoService;
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final RegistroPontoRepository registroPontoRepository;
    private final AtividadeDiariaRepository atividadeDiariaRepository;

    public RegistroPontoService (ChaveAcessoService chaveAcessoService, PessoaService pessoaService,
                                 PessoaRepository pessoaRepository, RegistroPontoRepository registroPontoRepository, AtividadeDiariaRepository atividadeDiariaRepository){
        this.atividadeDiariaRepository = atividadeDiariaRepository;
        this.pessoaRepository = pessoaRepository;
        this.chaveAcessoService = chaveAcessoService;
        this.registroPontoRepository = registroPontoRepository;
        this.pessoaService = pessoaService;
    }

    public RegistroPonto registrarBatida(BatidaPontoDTO dto){
       ChaveAcesso chaveEncontrada = chaveAcessoService.buscarEntidadePorChaveAcesso(dto.getCodigoRFID());

        Pessoa pessoa = chaveEncontrada.getPessoa();

        if(!pessoa.getStatusAtivo()){
            throw new ChaveAcessoService.BusinessException("O usuario: " + pessoa.getNome() + " está inativo.");
        }

        RegistroPonto novoRegistro = new RegistroPonto();
        novoRegistro.setChaveAcesso(chaveEncontrada);
        novoRegistro.setTipo(dto.getTipo());
        novoRegistro.setDataRegistro(Instant.now());
        novoRegistro.setPessoa(pessoa);

        return this.registroPontoRepository.save(novoRegistro);
    }

    public List<RegistroPontoResponseDTO> ListarRegistroPorMatricula (Integer matricula){
        Pessoa pessoa = pessoaService.buscarPessoaPorMatricula(matricula);
        List<RegistroPonto> registros = registroPontoRepository.findByPessoa(pessoa);
        return registros.stream()
                .map(registro -> toDTO(registro))
                .collect(Collectors.toList());
    }

    public RegistroPontoResponseDTO toDTO (RegistroPonto registro){
        RegistroPontoResponseDTO dto = new RegistroPontoResponseDTO();
        dto.setDataRegistro(registro.getDataRegistro());
        dto.setId(registro.getIdRegistro());
        dto.setTipo(registro.getTipo());
        return dto;
    }

    public RegistroPontoResponseDTO buscarUltimoRegistro(Integer matricula) {

        Pessoa pessoa = pessoaService.buscarPessoaPorMatricula(matricula);

        List<RegistroPonto> registros = registroPontoRepository.findByPessoaOrderByDataRegistroDesc(pessoa);

        if (registros.isEmpty()) {
            return null;
        }

        RegistroPonto ultimoRegistro = registros.get(0);

        return toDTO(ultimoRegistro);
    }
}
