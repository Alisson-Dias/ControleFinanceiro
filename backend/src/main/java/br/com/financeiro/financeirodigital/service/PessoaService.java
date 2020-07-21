package br.com.financeiro.financeirodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.PessoaModel;
import br.com.financeiro.financeirodigital.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;

	public PessoaModel login(PessoaModel pessoa) {
		
		String login = pessoa.getLogin();
		String senha = pessoa.getSenha();
		
		PessoaModel validacao = this.repository.findByLoginAndSenha(login, senha);	
		if (validacao == null) {
			return null;
		} else {
			return validacao;
		}	
	}
	
	public PessoaModel criar(PessoaModel pessoa) {
		
		String login = pessoa.getLogin();
		
		PessoaModel validacaoLogin = this.repository.findByLogin(login);
		
		if(validacaoLogin != null) {
				return null;
		}		
				this.repository.save(pessoa);
				return validacaoLogin;
	}
	public List<PessoaModel> findAll(){
		return this.repository.findAll();
	}
	public PessoaModel findById(Long id){
		return this.repository.findById(id).orElse(null);
	}
	public void save(PessoaModel pessoa) {
		repository.save(pessoa);
	}
}