package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.ppi2.projeto.domain.Locacao;
//import org.ppi2.projeto.repository.LocacaoRepository;
import org.ppi2.projeto.services.LocacaoService;
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
@RequestMapping("/locacoes")

public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Locacao Locacao = locacaoService.findById(id);			
			return ResponseEntity.ok(Locacao);
			
		} else {
			List<Locacao> Locacaos = locacaoService.findAll();			
			return ResponseEntity.ok(Locacaos);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Locacao Locacao) {
		
			
		Locacao = locacaoService.save(Locacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Locacao.getId()).buildAndExpand(Locacao.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Locacao Locacao) {
		
			
		Locacao.setId(id);
		Locacao = locacaoService.save(Locacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Locacao.getId()).buildAndExpand(Locacao.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		locacaoService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
