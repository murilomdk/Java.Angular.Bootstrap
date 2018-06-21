package org.ppi2.projeto.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.ppi2.projeto.domain.Veiculo;

@Repository

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	
	@Query("select veiculo from Veiculo veiculo where veiculo.categoria.id = ?1")
	public List<Veiculo> findByCategoriaId(Long id);

}
