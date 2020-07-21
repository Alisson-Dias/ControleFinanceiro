package br.com.financeiro.financeirodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.financeiro.financeirodigital.datasource.model.AlimentacaoModel;

public interface AlimentacaoRepository extends JpaRepository<AlimentacaoModel, Long>{
}
