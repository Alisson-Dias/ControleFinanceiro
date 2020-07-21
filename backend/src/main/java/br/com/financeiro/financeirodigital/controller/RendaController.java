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

import br.com.financeiro.financeirodigital.datasource.model.RendaModel;
import br.com.financeiro.financeirodigital.service.RendaService;

@RestController
@RequestMapping(value = "/renda")
public class RendaController {

	@Autowired
	private RendaService service;
	
	@GetMapping
	public List<RendaModel> buscarRenda(){
		return service.findAll();
	}
	
	@GetMapping(path ="/{id}")
	public RendaModel buscarValoresPorid(
		@PathVariable(name = "id", required = true)Long id){
			return service.findById(id);
	}
	
	@PostMapping
	public void salvarRenda(@RequestBody RendaModel renda) {
		service.save(renda);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteRenda(
			@PathVariable(name = "id", required = true)Long id) {
		service.deleteById(id);
	}
	
	@PutMapping(path = "/{id}")
	public void atualizarRenda(@PathVariable(name ="id", required = true)Long id,@RequestBody RendaModel renda) {
		renda.setId(id);
		service.save(renda);
	}
}
