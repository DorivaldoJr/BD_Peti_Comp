package com.peticompvc.bancodehoras.repository;

import com.peticompvc.bancodehoras.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByMatricula(Integer matricula);

    Optional<Pessoa> findByEmail(String email);

    Optional<Pessoa> findByMatriculaAndStatusAtivo(Integer matricula, boolean status);

    List<Pessoa> findByFuncao (String funcao);

    List<Pessoa> findByNome (String nome);

    List<Pessoa> findByStatusAtivoTrue();

    List<Pessoa> findByNomeContaining (String parteDoNome);
}
