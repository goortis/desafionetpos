package br.com.netpos.desafio.desafionetpos.controller.form;



import javax.validation.constraints.NotNull;

import br.com.netpos.desafio.desafionetpos.model.UserAccount;

public class UserAccountForm {
	
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserAccount converter() {
		return new UserAccount(name, email, password);
	}

}
