package br.com.financeiro.financeirodigital.datasource.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "Pessoa")
public class PessoaModel implements Serializable {

	private static final long serialVersionUID = -8377860408306971183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "{login.not.blank}")
	@org.hibernate.validator.constraints.Email(message = "{login.not.valid}")
	private String login;	
	
	@NotBlank(message = "{senha.not.blank}")
	private String senha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaModel")
	private Set<AlimentacaoModel> alimentacoes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaModel")
	private Set<MoradiaModel> moradias;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaModel")
	private Set<RendaModel> rendas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaModel")
	private Set<TransporteModel> transportes;
	
	
		public PessoaModel() {}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Set<AlimentacaoModel> getAlimentacoes() {
		return alimentacoes;
	}

	public void setAlimentacoes(Set<AlimentacaoModel> alimentacoes) {
		this.alimentacoes = alimentacoes;
	}

	public Set<MoradiaModel> getMoradias() {
		return moradias;
	}

	public void setMoradias(Set<MoradiaModel> moradias) {
		this.moradias = moradias;
	}

	public Set<RendaModel> getRendas() {
		return rendas;
	}

	public void setRendas(Set<RendaModel> rendas) {
		this.rendas = rendas;
	}

	public Set<TransporteModel> getTransportes() {
		return transportes;
	}

	public void setTransportes(Set<TransporteModel> transportes) {
		this.transportes = transportes;
	}
}
