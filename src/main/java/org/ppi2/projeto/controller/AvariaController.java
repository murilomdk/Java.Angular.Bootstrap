package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;


import org.ppi2.projeto.domain.Avaria;
import org.ppi2.projeto.services.AvariaService;
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
@RequestMapping("/avarias")

public class AvariaController {

	@Autowired
	private AvariaService avariaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Avaria Avaria = avariaService.findById(id);			
			return ResponseEntity.ok(Avaria);
			
		} else {
			List<Avaria> Avarias = avariaService.findAll();			
			return ResponseEntity.ok(Avarias);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Avaria Avaria) {
		
			
		Avaria = avariaService.save(Avaria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Avaria.getId()).buildAndExpand(Avaria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Avaria Avaria) {
		
			
		Avaria.setId(id);
		Avaria = avariaService.save(Avaria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Avaria.getId()).buildAndExpand(Avaria.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		avariaService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
