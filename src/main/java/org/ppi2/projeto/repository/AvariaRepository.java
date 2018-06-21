package org.ppi2.projeto.repository;

import org.ppi2.projeto.domain.Avaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AvariaRepository  extends JpaRepository<Avaria, Long> {

}
