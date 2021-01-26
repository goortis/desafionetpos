package br.com.netpos.desafio.desafionetpos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netpos.desafio.desafionetpos.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByUserAccountId(Long id);
}
