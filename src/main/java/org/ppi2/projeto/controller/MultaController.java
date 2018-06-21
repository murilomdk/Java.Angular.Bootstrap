package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;
import org.ppi2.projeto.domain.Multa;
import org.ppi2.projeto.services.MultaService;
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
@RequestMapping("/multas")

public class MultaController {

	@Autowired
	private MultaService multaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Multa Multa = multaService.findById(id);			
			return ResponseEntity.ok(Multa);
			
		} else {
			List<Multa> Multas = multaService.findAll();			
			return ResponseEntity.ok(Multas);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Multa Multa) {
		
			
		Multa = multaService.save(Multa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Multa.getId()).buildAndExpand(Multa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Multa Multa) {
		
			
		Multa.setId(id);
		Multa = multaService.save(Multa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Multa.getId()).buildAndExpand(Multa.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		multaService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
