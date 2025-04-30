package br.com.unicuritiba.Investimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.Investimento.models.User;

public interface UserRepository 
			extends JpaRepository<User, Long> {
	
}
