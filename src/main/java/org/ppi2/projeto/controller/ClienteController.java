package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.ppi2.projeto.domain.Cliente;
//import org.ppi2.projeto.repository.ClienteRepository;
import org.ppi2.projeto.services.ClienteService;
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
@RequestMapping("/clientes")

public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Cliente Cliente = clienteService.findById(id);			
			return ResponseEntity.ok(Cliente);
			
		} else {
			List<Cliente> Clientes = clienteService.findAll();			
			return ResponseEntity.ok(Clientes);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Cliente Cliente) {
		
			
		Cliente = clienteService.save(Cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Cliente.getId()).buildAndExpand(Cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Cliente Cliente) {
		
			
		Cliente.setId(id);
		Cliente = clienteService.save(Cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Cliente.getId()).buildAndExpand(Cliente.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		clienteService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
