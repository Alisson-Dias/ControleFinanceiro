package br.com.financeiro.financeirodigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.financeirodigital.datasource.model.MoradiaModel;
import br.com.financeiro.financeirodigital.service.MoradiaService;

@RestController
@RequestMapping(value = "/moradia")
public class MoradiaController {

	@Autowired
	private MoradiaService service;

	@GetMapping
	public List<MoradiaModel> buscarMoradia(){
		return service.findAll();
	}
	@GetMapping(path ="/{id}")
	public MoradiaModel buscarMoradiaPorid(
		@PathVariable(name = "id", required = true)Long id){
			return service.findById(id);
	}	
	@PostMapping
	public void salvarMoradia(@RequestBody MoradiaModel moradia) {
		service.save(moradia);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteMoradia(
			@PathVariable(name = "id", required = true)Long id) {
		service.deleteById(id);
	}
	@PutMapping(path = "/{id}")
	public void atualizarMoradia(@PathVariable(name ="id", required = true)Long id,@RequestBody MoradiaModel moradia){
			moradia.setId(id);
			service.save(moradia);
	}
}