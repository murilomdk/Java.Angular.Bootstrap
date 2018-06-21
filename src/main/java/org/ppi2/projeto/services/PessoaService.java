package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Pessoa;
import org.ppi2.projeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class PessoaService {
	
	
	@Autowired	
	private PessoaRepository pessoaRepository;

	
	@Transactional
	public Pessoa findById(Long id) {
		
		return pessoaRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Pessoa> findAll() {
		
		return pessoaRepository.findAll();
		
	}
	
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		pessoaRepository.deleteById(id);
		
	}
	
}
