package br.com.financeiro.financeirodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financeiro.financeirodigital.datasource.model.MoradiaModel;

public interface MoradiaRepository extends JpaRepository<MoradiaModel, Long>  {
}