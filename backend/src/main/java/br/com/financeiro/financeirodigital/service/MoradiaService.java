package br.com.financeiro.financeirodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.PessoaModel;
import br.com.financeiro.financeirodigital.datasource.model.MoradiaModel;
import br.com.financeiro.financeirodigital.repository.MoradiaRepository;

@Service
public class MoradiaService {
	
	PessoaModel entrar;
	@Autowired
	private MoradiaRepository repository;
	

	public void cadastro(MoradiaModel moradia) {
	
		
		repository.saveAndFlush(moradia);
	}
	public List<MoradiaModel> findAll(){
		return repository.findAll();
	}
	public MoradiaModel findById(Long id){
		return this.repository.findById(id).orElse(null);
	}
	public void save(MoradiaModel moradia) {
		repository.save(moradia);
	}
	public void  deleteById(Long id) {
		repository.deleteById(id);
	}
}
