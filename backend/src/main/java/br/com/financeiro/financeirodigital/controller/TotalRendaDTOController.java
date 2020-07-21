package br.com.financeiro.financeirodigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.financeirodigital.service.TotalRendaDTOService;
import br.com.financeiro.financeirodigital.total.dto.TotalRendaDTO;

@RestController
@RequestMapping(value ="/totalRenda")
public class TotalRendaDTOController {
	
	@Autowired
	private TotalRendaDTOService totalRendaDTOService;

	@GetMapping(path="/{id}")
	public TotalRendaDTO buscarRedaDRO(@PathVariable(name="id", required = true)Long id) {
		return totalRendaDTOService.total(id);
	}
	
}
