package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Avaria;
import org.ppi2.projeto.repository.AvariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AvariaService {
	
	
	@Autowired	
	private AvariaRepository avariaRepository;

	
	@Transactional
	public Avaria findById(Long id) {
		
		return avariaRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Avaria> findAll() {
		
		return avariaRepository.findAll();
		
	}
	
	@Transactional
	public Avaria save(Avaria Avaria) {
		
		return avariaRepository.save(Avaria);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		avariaRepository.deleteById(id);
		
	}
	
}
