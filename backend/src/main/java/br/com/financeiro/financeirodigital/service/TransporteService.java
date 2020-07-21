package br.com.financeiro.financeirodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.TransporteModel;
import br.com.financeiro.financeirodigital.repository.TransporteRepository;

@Service
public class TransporteService {
	
	@Autowired
	private TransporteRepository repository;

	public void cadastro(TransporteModel transporte) {
		repository.saveAndFlush(transporte);
	}
	public List<TransporteModel> findAll(){
		return repository.findAll();
	}
	public TransporteModel findById(Long id){
		return this.repository.findById(id).orElse(null);
	}
	public void save(TransporteModel transporte){
		repository.save(transporte);
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
