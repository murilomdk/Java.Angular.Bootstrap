package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.ppi2.projeto.domain.Pessoa;
//import org.ppi2.projeto.repository.PessoaRepository;
import org.ppi2.projeto.services.PessoaService;
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
@RequestMapping("/pessoas")

public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Pessoa pessoa = pessoaService.findById(id);			
			return ResponseEntity.ok(pessoa);
			
		} else {
			List<Pessoa> pessoas = pessoaService.findAll();			
			return ResponseEntity.ok(pessoas);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Pessoa pessoa) {
		
			
		pessoa = pessoaService.save(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", pessoa.getId()).buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Pessoa pessoa) {
		
			
		pessoa.setId(id);
		pessoa = pessoaService.save(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", pessoa.getId()).buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		pessoaService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
