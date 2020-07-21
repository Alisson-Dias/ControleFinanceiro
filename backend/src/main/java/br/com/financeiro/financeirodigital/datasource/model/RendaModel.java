package br.com.financeiro.financeirodigital.datasource.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Renda")
public class RendaModel implements Serializable{
	private static final long serialVersionUID = -46074219401260262L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valorRenda;
	
	@ManyToOne
	@JoinColumn(updatable = false)
	PessoaModel pessoaModel;
	
	public RendaModel() {}
	
	public RendaModel(double valorRenda) {
		this.valorRenda = valorRenda;
	}
	public double getValorRenda() {
		return valorRenda;
	}
	public void setValorRenda(double valorRenda) {
		this.valorRenda = valorRenda;
	}
	@JsonProperty(access = Access.WRITE_ONLY)
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	@JsonIgnore
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
}
