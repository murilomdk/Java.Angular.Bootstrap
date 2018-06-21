package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Veiculo;
import org.ppi2.projeto.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class VeiculoService {
	
	
	@Autowired	
	private VeiculoRepository veiculoRepository;

	
	@Transactional
	public Veiculo findById(Long id) {
		
		return veiculoRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Veiculo> findAll() {
		
		return veiculoRepository.findAll();
		
	}
	
	@Transactional
	public Veiculo save(Veiculo Veiculo) {
		
		return veiculoRepository.save(Veiculo);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		veiculoRepository.deleteById(id);
		
	}

	
	// finds
	
	@Transactional
	public List <Veiculo> findByCategoriaId (Long id) {
		
		return veiculoRepository.findByCategoriaId(id);
		
	}
	
	
	
	
}
