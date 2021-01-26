package br.com.netpos.desafio.desafionetpos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.netpos.desafio.desafionetpos.controller.dto.ProductDto;
import br.com.netpos.desafio.desafionetpos.controller.dto.UserAccountDto;
import br.com.netpos.desafio.desafionetpos.controller.form.ProductForm;
import br.com.netpos.desafio.desafionetpos.controller.form.UpdateProductForm;
import br.com.netpos.desafio.desafionetpos.controller.form.UserAccountForm;
import br.com.netpos.desafio.desafionetpos.model.Product;
import br.com.netpos.desafio.desafionetpos.model.UserAccount;
import br.com.netpos.desafio.desafionetpos.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	// Lista todos os objetos Product
	@GetMapping
	public List<ProductDto> listProduct(Long id) {
			List<Product> product = productRepository.findAll();
			return ProductDto.converter(product);
	}

	// Cria um novo objeto Product
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		Product product = form.converter();
		productRepository.save(product);
		
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}
	
	// Retorna os detalhes de um objeto Product
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> product(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(new ProductDto(product.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	// Atualiza um objeto Product
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProductForm form){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = form.update(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}
	
	// Deleta um objeto Product
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

