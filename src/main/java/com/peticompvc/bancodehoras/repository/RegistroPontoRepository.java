package com.peticompvc.bancodehoras.repository;
import com.peticompvc.bancodehoras.model.Pessoa;
import com.peticompvc.bancodehoras.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.time.Instant;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long>{

    List<RegistroPonto> findByPessoa (Pessoa pessoa);

    List<RegistroPonto> findByPessoaOrderByDataRegistroDesc (Pessoa pessoa);

    Optional<RegistroPonto> findByDataRegistro ();

    // Funçao que posteriormente sera usada apos o processmento no service(Calculo intervalo entre inicio e fim do dia exato)
    List<RegistroPonto> findByPessoaAndDataRegistroBetween(Pessoa pessoa, Instant inicioDoDia, Instant fimDoDia);

    List<RegistroPonto> findByPessoaAndDataRegistroBetweenOrderByDataRegistroAsc(Pessoa pessoa, Instant inicioDoDia, Instant fimDoDia);
}
