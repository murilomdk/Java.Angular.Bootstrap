package org.ppi2.projeto.services;



import java.util.List;

import org.ppi2.projeto.domain.Cliente;
import org.ppi2.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ClienteService {
	
	
	@Autowired	
	private ClienteRepository clienteRepository;

	
	@Transactional
	public Cliente findById(Long id) {
		
		return clienteRepository.findById(id).get();
		
	}
	
	
	@Transactional
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
		
	}
	
	@Transactional
	public Cliente save(Cliente Cliente) {
		
		return clienteRepository.save(Cliente);
		
	}
	
	@Transactional
	public void delete(Long id) {
		
		clienteRepository.deleteById(id);
		
	}
	
}
