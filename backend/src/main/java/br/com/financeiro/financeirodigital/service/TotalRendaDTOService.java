package br.com.financeiro.financeirodigital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.financeirodigital.datasource.model.AlimentacaoModel;
import br.com.financeiro.financeirodigital.datasource.model.MoradiaModel;
import br.com.financeiro.financeirodigital.datasource.model.RendaModel;
import br.com.financeiro.financeirodigital.datasource.model.TransporteModel;
import br.com.financeiro.financeirodigital.repository.AlimentacaoRepository;
import br.com.financeiro.financeirodigital.repository.MoradiaRepository;
import br.com.financeiro.financeirodigital.repository.RendaRepository;
import br.com.financeiro.financeirodigital.repository.TransporteRepository;
import br.com.financeiro.financeirodigital.total.dto.TotalRendaDTO;

@Service
public class TotalRendaDTOService {
	
	@Autowired
	private TransporteRepository transporteRepository;
	@Autowired
	private AlimentacaoRepository alimentacaoRepository;
	@Autowired
	private RendaRepository rendasRepository;
	@Autowired
	private MoradiaRepository moradiaRepository;
	
	public TotalRendaDTO total(Long id) {
		
		TransporteModel transporte = this.transporteRepository.findById((long) id).orElse(null);
		AlimentacaoModel alimentacao = this.alimentacaoRepository.findById((long) id).orElse(null);
		RendaModel renda = this.rendasRepository.findById((long) id).orElse(null);
		MoradiaModel moradia = this.moradiaRepository.findById((long) id).orElse(null);
		
		TotalRendaDTO resultado = new TotalRendaDTO(alimentacao, moradia, transporte, renda);
		return resultado;		
	}	
}
