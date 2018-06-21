package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Funcionario;
import org.ppi2.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class FuncionarioService {
	
	
	@Autowired	
	private FuncionarioRepository funcionarioRepository;

	
	@Transactional
	public Funcionario findById(Long id) {
		
		return funcionarioRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Funcionario> findAll() {
		
		return funcionarioRepository.findAll();
		
	}
	
	@Transactional
	public Funcionario save(Funcionario Funcionario) {
		
		return funcionarioRepository.save(Funcionario);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		funcionarioRepository.deleteById(id);
		
	}
	
}
