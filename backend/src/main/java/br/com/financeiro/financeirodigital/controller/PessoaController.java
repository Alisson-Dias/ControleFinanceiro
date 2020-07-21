package br.com.financeiro.financeirodigital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.financeirodigital.datasource.model.PessoaModel;
import br.com.financeiro.financeirodigital.service.PessoaService;

@RestController
@RequestMapping(value="/login")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@PostMapping
	public PessoaModel login(@RequestBody @Valid PessoaModel pessoa){
		PessoaModel valido = service.login(pessoa);
		if(valido != null) {
			return valido;
		}else {
			return null;
		}
	}
	@PostMapping(path ="/criar")
	public PessoaModel criar(@RequestBody @Valid PessoaModel pessoa) {
		 PessoaModel emailValido = service.criar(pessoa);
		if(emailValido == null) {
			return pessoa;
		}else {
			return emailValido;
		}	
	}
	@GetMapping
	public List<PessoaModel> buscarEntrar(){
		return service.findAll();
	}
	@GetMapping(path ="/{id}")
	public PessoaModel buscarentrarPorid(
		@PathVariable(name = "id", required = true)Long id){
			return service.findById(id);
	}
	@PutMapping(path = "/atualizar/{id}")
	public void atualizarPessoa (@PathVariable(name ="id", required = true)Long id, @RequestBody PessoaModel pessoa) {
		pessoa.setId(id);
		service.save(pessoa);
	}
	
}

