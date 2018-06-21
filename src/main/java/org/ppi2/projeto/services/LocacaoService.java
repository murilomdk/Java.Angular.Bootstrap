package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Locacao;
import org.ppi2.projeto.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class LocacaoService {
	
	
	@Autowired	
	private LocacaoRepository locacaoRepository;

	
	@Transactional
	public Locacao findById(Long id) {
		
		return locacaoRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Locacao> findAll() {
		
		return locacaoRepository.findAll();
		
	}
	
	@Transactional
	public Locacao save(Locacao Locacao) {
		
		return locacaoRepository.save(Locacao);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		locacaoRepository.deleteById(id);
		
	}
	
	@Transactional
	public List <Locacao> findByVeiculo (Long id) {
		
		return locacaoRepository.findByVeiculo(id);
		
	}
}
