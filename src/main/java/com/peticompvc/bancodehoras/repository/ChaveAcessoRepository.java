package com.peticompvc.bancodehoras.repository;

import com.peticompvc.bancodehoras.model.ChaveAcesso;
import com.peticompvc.bancodehoras.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChaveAcessoRepository extends JpaRepository<ChaveAcesso,Long >{

    Optional<ChaveAcesso> findByValorChave (String valorChave);

    Optional<ChaveAcesso> findByPessoa (Pessoa pessoa);
}
