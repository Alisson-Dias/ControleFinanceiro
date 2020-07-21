package br.com.financeiro.financeirodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.financeiro.financeirodigital.datasource.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
	public PessoaModel findByLoginAndSenha(final String login, final String senha);
	public PessoaModel findByLogin(final String login);

}
