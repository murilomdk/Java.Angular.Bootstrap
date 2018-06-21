package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Categoria;
import org.ppi2.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CategoriaService {
	
	
	@Autowired	
	private CategoriaRepository categoriaRepository;

	
	@Transactional
	public Categoria findById(Long id) {
		
		return categoriaRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
		
	}
	
	@Transactional
	public Categoria save(Categoria Categoria) {
		
		return categoriaRepository.save(Categoria);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		categoriaRepository.deleteById(id);
		
	}
	
}
