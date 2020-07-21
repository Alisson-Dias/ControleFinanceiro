package br.com.financeiro.financeirodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financeiro.financeirodigital.datasource.model.TransporteModel;

public interface TransporteRepository extends JpaRepository<TransporteModel, Long> {

}
