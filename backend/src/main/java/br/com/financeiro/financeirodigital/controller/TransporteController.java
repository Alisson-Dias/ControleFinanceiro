package br.com.financeiro.financeirodigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.financeirodigital.datasource.model.TransporteModel;
import br.com.financeiro.financeirodigital.service.TransporteService;

@RestController
@RequestMapping(value = "/transporte")
public class TransporteController {

	@Autowired
	private TransporteService service;
	
	@GetMapping
	public List<TransporteModel> buscarTransporte(){
		return service.findAll();
	}
	@GetMapping(path ="/{id}")
	public TransporteModel buscarTransportePorid(
		@PathVariable(name = "id", required = true)Long id){
			return service.findById(id);
	}
	@PostMapping
	public void salvarTransporte(@RequestBody TransporteModel transporte) {
		service.save(transporte);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteTransporte(
			@PathVariable(name = "id", required = true)Long id) {
		service.deleteById(id);
	}
	@PostMapping(path ="/{id}")
	public void atualizarTransporte(@PathVariable(name ="id", required = true)Long id, @RequestBody TransporteModel transporte) {
		transporte.setId(id);
		service.save(transporte);
	}	
}