package br.com.financeiro.financeirodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.AlimentacaoModel;
import br.com.financeiro.financeirodigital.repository.AlimentacaoRepository;

@Service 
public class AlimentacaoService {
	
	@Autowired
	private AlimentacaoRepository repository;
	
	public void cadastro(AlimentacaoModel alimentacao) {
		repository.saveAndFlush(alimentacao);
	}
	public void save(AlimentacaoModel alimentacao) {
		repository.save(alimentacao);
	}
	public List<AlimentacaoModel> findAll(){
		return repository.findAll();
	}
}
