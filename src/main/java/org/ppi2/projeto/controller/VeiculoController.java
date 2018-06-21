package org.ppi2.projeto.controller;

import java.net.URI;
import java.util.List;

//import javax.websocket.server.PathParam;

import org.ppi2.projeto.domain.Veiculo;
//import org.ppi2.projeto.repository.VeiculoRepository;
import org.ppi2.projeto.services.VeiculoService;
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
@RequestMapping("/veiculos")

public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listAll(@RequestParam (name="id", required=false) Long id ) { 
		
		if(id != null) {
			
			
			Veiculo Veiculo = veiculoService.findById(id);			
			return ResponseEntity.ok(Veiculo);
			
		} else {
			List<Veiculo> Veiculos = veiculoService.findAll();			
			return ResponseEntity.ok(Veiculos);
		}	
		
	}
	
	@RequestMapping(value="/categoria/{idcategoria}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<Object> listByCategoriaId(@RequestParam (name="idcategoria", required=false) Long idCategoria ) { 
		
		List <Veiculo> veiculo = veiculoService.findByCategoriaId(idCategoria);
		return ResponseEntity.ok(veiculo); 
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> save( @RequestBody Veiculo Veiculo) {
		
			
		Veiculo = veiculoService.save(Veiculo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Veiculo.getId()).buildAndExpand(Veiculo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT, consumes = "application/json" )
	public @ResponseBody HttpEntity<Void> update(@PathVariable(value="id") Long id,
			@RequestBody Veiculo Veiculo) {
		
			
		Veiculo.setId(id);
		Veiculo = veiculoService.save(Veiculo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("id", Veiculo.getId()).buildAndExpand(Veiculo.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<Void> delete(@PathVariable(value="id") Long id) {
		
			
		
		veiculoService.delete(id);	
		return ResponseEntity.noContent().build();
	} 

	
}
