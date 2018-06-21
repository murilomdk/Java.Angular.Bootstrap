package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;


import org.ppi2.projeto.domain.Categoria;
//import org.ppi2.projeto.repository.CategoriaRepository;
import org.ppi2.projeto.services.CategoriaService;
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
@RequestMapping("/categorias")

public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			Categoria Categoria = categoriaService.findById(id);			
			return ResponseEntity.ok(Categoria);
			
		} else {
			List<Categoria> Categorias = categoriaService.findAll();			
			return ResponseEntity.ok(Categorias);
		}	
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Categoria Categoria) {
		
			
		Categoria = categoriaService.save(Categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Categoria.getId()).buildAndExpand(Categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Categoria Categoria) {
		
			
		Categoria.setId(id);
		Categoria = categoriaService.save(Categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Categoria.getId()).buildAndExpand(Categoria.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		categoriaService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
