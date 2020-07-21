package br.com.financeiro.financeirodigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.financeirodigital.datasource.model.AlimentacaoModel;
import br.com.financeiro.financeirodigital.service.AlimentacaoService;

@RestController
@RequestMapping(value = "/alimentacao")
public class AlimentacaoController {

	@Autowired
	private AlimentacaoService service;

	@GetMapping
	public List<AlimentacaoModel> buscarAlimentacao(){
		return service.findAll();
	}
	@PostMapping
	public void saveAlimentacao(@RequestBody AlimentacaoModel alimentacao) {
		service.save(alimentacao);
	}
	@PutMapping(path = "/{id}")
	public void atualizarAlimentacao (@PathVariable( name ="id", required = true)Long id,@RequestBody AlimentacaoModel alimentacao) {
		alimentacao.setId(id);
		service.save(alimentacao);
	}
}
	