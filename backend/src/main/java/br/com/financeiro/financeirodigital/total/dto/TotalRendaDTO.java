package br.com.financeiro.financeirodigital.total.dto;
import br.com.financeiro.financeirodigital.datasource.model.AlimentacaoModel;
import br.com.financeiro.financeirodigital.datasource.model.MoradiaModel;
import br.com.financeiro.financeirodigital.datasource.model.RendaModel;
import br.com.financeiro.financeirodigital.datasource.model.TransporteModel;

public class TotalRendaDTO {
	
	private double receita;
	private double lucroPrejuizo;
	private double despesas;
	private double lucratividade;
	
	public TotalRendaDTO(AlimentacaoModel alimentacao, MoradiaModel moradia,TransporteModel transporte,RendaModel renda) {
		
		double totalLanche = alimentacao.getValorBarLanche();
		double totalRestaurante = alimentacao.getValorRestaurante();
		double totalSuperMercado = alimentacao.getValorSupermercado();

		double totalAlimentacao = totalLanche + totalRestaurante + totalSuperMercado;
		
		double totalAluguel = moradia.getValorAluguel();
		double totalCondominio = moradia.getValorCondominio();
		double totalContaLuz = moradia.getValorContaLuz();
		double totalContaAgua = moradia.getValorContaAgua();
		double totalGas = moradia.getValorGas();
		double totalIptu = moradia.getValorIptu();
		double totalTelefone = moradia.getValorTelefone();
		double totalCelular = moradia.getValorTelefoneCelular();
		double totalManutencao = moradia.getValorConserto();
		
		double totalMoradia = totalAluguel + totalCondominio + totalContaLuz + totalContaAgua +totalGas
				+ totalIptu + totalTelefone + totalCelular + totalManutencao;
		
		double totalCombustivel = transporte.getValorCombustivel();
		double totalPublico = transporte.getValorTransportePublico();
		double totalPrivado = transporte.getValorTransportePrivado();
		
		double totalTransporte = totalCombustivel + totalPublico + totalPrivado;
		
		this.despesas = totalAlimentacao + totalMoradia + totalTransporte;

		this.receita = renda.getValorRenda();
		
		this.lucroPrejuizo = receita - despesas;		
		
		this.lucratividade = (lucroPrejuizo/receita)*100;
		
		lucratividade = Double.valueOf(String.format("%.2f", Math.ceil(lucratividade)));
	}
	public double getReceita() {
		return receita;
	}

	public void setReceita(double receita) {
		this.receita = receita;
	}
	public double getLucroPrejuizo() {
		return lucroPrejuizo;
	} 
	public void setLucroPrejuizo(double lucroPrejuizo) {
		this.lucroPrejuizo = lucroPrejuizo;
	}
	public double getDespesas() {
		return despesas;
	}
	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}
	public double getLucratividade() {
		return lucratividade;
	}
	public void setLucratividade(double lucratividade) {
		this.lucratividade = lucratividade;
	}
	
}