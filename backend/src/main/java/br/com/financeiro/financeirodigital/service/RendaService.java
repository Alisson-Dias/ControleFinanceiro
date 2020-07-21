package br.com.financeiro.financeirodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.RendaModel;
import br.com.financeiro.financeirodigital.repository.RendaRepository;
@Service
public class RendaService {
	
	@Autowired
	private RendaRepository repository;
	
	public void cadastro(RendaModel renda) {
		repository.saveAndFlush(renda);
	}
	public List<RendaModel> findAll(){
		return repository.findAll();
	}
	public RendaModel findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	public void save(RendaModel renda){
		repository.save(renda);
	}
	public void  deleteById(Long id) {
		repository.deleteById(id);
	}
}
