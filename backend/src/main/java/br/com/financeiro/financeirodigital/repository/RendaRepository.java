package br.com.financeiro.financeirodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financeiro.financeirodigital.datasource.model.RendaModel;

public interface RendaRepository extends JpaRepository<RendaModel, Long>{
}
