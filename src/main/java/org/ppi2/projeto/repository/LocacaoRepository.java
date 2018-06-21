package org.ppi2.projeto.repository;

import java.util.List;

import org.ppi2.projeto.domain.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.ppi2.projeto.domain.Pessoa;


@Repository

public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

	@Query("select locacao from Locacao locacao where locacao.veiculo.id = ?1")
	public List<Locacao> findByVeiculo(Long id);
	

}
