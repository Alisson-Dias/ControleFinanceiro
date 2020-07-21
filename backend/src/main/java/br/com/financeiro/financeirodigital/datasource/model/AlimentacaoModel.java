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


/**
 * @author Alisson
 *
 */
@Entity
@Table(name = "alimentacao")
public class AlimentacaoModel implements Serializable{

	private static final long serialVersionUID = -5437426275777323117L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double valorSupermercado;
	private double valorRestaurante;
	private double valorBarLanche;

	@ManyToOne
	@JoinColumn(updatable = false)
	PessoaModel pessoaModel;
	
	
	public AlimentacaoModel() {}
	
	public AlimentacaoModel(double valorSupermercado, double valorRestaurante, double valorBarLanche) {
		this.valorSupermercado = valorSupermercado;
		this.valorRestaurante = valorRestaurante;
		this.valorBarLanche = valorBarLanche;
	}
	public double getValorSupermercado() {
		return valorSupermercado;
	}
	public void setValorSupermercado(double valorSupermercado) {
		this.valorSupermercado = valorSupermercado;
	}
	public double getValorRestaurante() {
		return valorRestaurante;
	}
	public void setValorRestaurante(double valorRestaurante) {
		this.valorRestaurante = valorRestaurante;
	}
	public double getValorBarLanche() {
		return valorBarLanche;
	}
	public void setValorBarLanche(double valorBarLanche) {
		this.valorBarLanche = valorBarLanche;
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
