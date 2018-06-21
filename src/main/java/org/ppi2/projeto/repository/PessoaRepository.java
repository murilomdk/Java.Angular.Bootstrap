package org.ppi2.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ppi2.projeto.domain.Pessoa;


@Repository

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
