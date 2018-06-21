package org.ppi2.projeto.repository;


import org.ppi2.projeto.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
