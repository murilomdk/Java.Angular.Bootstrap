package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.ppi2.projeto.domain.Funcionario;
//import org.ppi2.projeto.repository.FuncionarioRepository;
import org.ppi2.projeto.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Funcionario Funcionario = funcionarioService.findById(id);			
			return ResponseEntity.ok(Funcionario);
			
		} else {
			List<Funcionario> Funcionarios = funcionarioService.findAll();			
			return ResponseEntity.ok(Funcionarios);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Funcionario Funcionario) {
		
			
		Funcionario = funcionarioService.save(Funcionario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Funcionario.getId()).buildAndExpand(Funcionario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Funcionario Funcionario) {
		
			
		Funcionario.setId(id);
		Funcionario = funcionarioService.save(Funcionario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Funcionario.getId()).buildAndExpand(Funcionario.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		funcionarioService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
