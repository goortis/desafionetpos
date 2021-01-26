package br.com.netpos.desafio.desafionetpos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.netpos.desafio.desafionetpos.model.UserAccount;

public class UserAccountDto {

	private Long id;
	private String name;
	private String email;
	
	public UserAccountDto(UserAccount userAccount) {
		this.id = userAccount.getId();
		this.name = userAccount.getName();
		this.email = userAccount.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public static List<UserAccountDto> converter(List<UserAccount> userAccount) {
		return userAccount.stream().map(UserAccountDto::new).collect(Collectors.toList());
	}
	
}
