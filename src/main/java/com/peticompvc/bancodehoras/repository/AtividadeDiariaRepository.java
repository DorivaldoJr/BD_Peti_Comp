package com.peticompvc.bancodehoras.repository;
import com.peticompvc.bancodehoras.model.AtividadeDiaria;
import com.peticompvc.bancodehoras.model.Pessoa;
import com.peticompvc.bancodehoras.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AtividadeDiariaRepository extends JpaRepository<AtividadeDiaria, Long> {

    Optional<AtividadeDiaria> findByPessoaAndDataAtividade(Pessoa pessoa, LocalDate dataAtividade);

    List<AtividadeDiaria> findByPessoa(Pessoa pessoa);
}