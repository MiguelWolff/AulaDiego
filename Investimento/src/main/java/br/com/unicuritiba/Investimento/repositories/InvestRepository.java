package br.com.unicuritiba.Investimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.Investimento.models.Invest;

public interface InvestRepository 
extends JpaRepository<Invest, Long> {

}