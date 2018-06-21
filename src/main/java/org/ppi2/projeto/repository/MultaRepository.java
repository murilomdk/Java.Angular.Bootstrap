package org.ppi2.projeto.repository;

import org.ppi2.projeto.domain.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MultaRepository extends JpaRepository<Multa, Long> {

	
}
