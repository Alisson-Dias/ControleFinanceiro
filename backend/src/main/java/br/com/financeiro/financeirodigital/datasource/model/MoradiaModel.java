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
@Table(name = "Moradia")
public class MoradiaModel implements Serializable {

	private static final long serialVersionUID = -8377860408306971183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valorAluguel;
	private double valorCondominio;
	private double valorContaLuz;
	private double valorContaAgua;
	private double valorGas;
	private double valorIptu;
	private double valorTelefone;
	private double valorTelefoneCelular;
	private double valorConserto;
	

	@ManyToOne
	@JoinColumn(updatable = false)
	PessoaModel pessoaModel;
	
	public MoradiaModel() {}


	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public double getValorCondominio() {
		return valorCondominio;
	}
	public void setValorCondominio(double valorCondominio) {
		this.valorCondominio = valorCondominio;
	}
	public double getValorContaLuz() {
		return valorContaLuz;
	}
	public void setValorContaLuz(double valorContaLuz) {
		this.valorContaLuz = valorContaLuz;
	}
	public double getValorContaAgua() {
		return valorContaAgua;
	}
	public void setValorContaAgua(double valorContaAgua) {
		this.valorContaAgua = valorContaAgua;
	}
	public double getValorGas() {
		return valorGas;
	}
	public void setValorGas(double valorGas) {
		this.valorGas = valorGas;
	}
	public double getValorIptu() {
		return valorIptu;
	}
	public void setValorIptu(double valorIptu) {
		this.valorIptu = valorIptu;
	}
	public double getValorTelefone() {
		return valorTelefone;
	}
	public void setValorTelefone(double valorTelefone) {
		this.valorTelefone = valorTelefone;
	}
	public double getValorTelefoneCelular() {
		return valorTelefoneCelular;
	}
	public void setValorTelefoneCelular(double valorTelefoneCelular) {
		this.valorTelefoneCelular = valorTelefoneCelular;
	}
	public double getValorConserto() {
		return valorConserto;
	}
	public void setValorConserto(double valorConserto) {
		this.valorConserto = valorConserto;
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
	
	
	