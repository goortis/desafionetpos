package br.com.netpos.desafio.desafionetpos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netpos.desafio.desafionetpos.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

	List<UserAccount> findByName(String name);

}
