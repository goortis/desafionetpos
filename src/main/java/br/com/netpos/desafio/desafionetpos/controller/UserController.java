package br.com.netpos.desafio.desafionetpos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.netpos.desafio.desafionetpos.controller.dto.UserAccountDto;
import br.com.netpos.desafio.desafionetpos.controller.form.ProductForm;
import br.com.netpos.desafio.desafionetpos.controller.form.UserAccountForm;
import br.com.netpos.desafio.desafionetpos.model.Product;
import br.com.netpos.desafio.desafionetpos.model.UserAccount;
import br.com.netpos.desafio.desafionetpos.repository.UserAccountRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	// Lista todos os objetos UserAccount
	@GetMapping
	@Transactional
	public List<UserAccountDto> listUsers(String name) {
		if (name == null) {
			List<UserAccount> userAccount = userAccountRepository.findAll();
			return UserAccountDto.converter(userAccount);
		} else {
			List<UserAccount> userAccount = userAccountRepository.findByName(name);
			return UserAccountDto.converter(userAccount);
		}
	}
	
	// Cria um novo objeto UserAccount
	@PostMapping
	@Transactional
	public ResponseEntity<UserAccountDto> createUserAccount(@RequestBody @Valid UserAccountForm form, UriComponentsBuilder uriBuilder) {
		UserAccount userAccount = form.converter();
		userAccountRepository.save(userAccount);
		
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userAccount.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserAccountDto(userAccount));
	}
	
	// Retorna os detalhes de um objeto UserAccount
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<UserAccountDto> userAccount(@PathVariable Long id) {
		Optional<UserAccount> userAccount = userAccountRepository.findById(id);
		if(userAccount.isPresent()) {
			return ResponseEntity.ok(new UserAccountDto(userAccount.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
