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
@Table(name = "transporte")
public class TransporteModel implements Serializable{

	private static final long serialVersionUID = 3914708672080726264L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Publico e Privado são Transportes
	private double valorCombustivel;
	private double valorTransportePublico;
	private double valorTransportePrivado;
	

	@ManyToOne
	@JoinColumn(updatable = false)
	PessoaModel pessoaModel;
	
	public TransporteModel() {	
	}
	
	public TransporteModel(double valorCombustivel, double valorTransportePublico, double valorTransportePrivado) {
		this.valorCombustivel = valorCombustivel;
		this.valorTransportePublico = valorTransportePublico;
		this.valorTransportePrivado = valorTransportePrivado;
	}
	public double getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(double valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}
	public double getValorTransportePublico() {
		return valorTransportePublico;
	}
	public void setValorTransportePublico(double valorTransportePublico) {
		this.valorTransportePublico = valorTransportePublico;
	}
	public double getValorTransportePrivado() {
		return valorTransportePrivado;
	}
	public void setValorTransportePrivado(double valorTransportePrivado) {
		this.valorTransportePrivado = valorTransportePrivado;
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
