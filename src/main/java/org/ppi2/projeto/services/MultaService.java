package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Multa;
import org.ppi2.projeto.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class MultaService {
	
	
	@Autowired	
	private MultaRepository multaRepository;

	
	@Transactional
	public Multa findById(Long id) {
		
		return multaRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Multa> findAll() {
		
		return multaRepository.findAll();
		
	}
	
	@Transactional
	public Multa save(Multa Multa) {
		
		return multaRepository.save(Multa);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		multaRepository.deleteById(id);
		
	}
	
}
