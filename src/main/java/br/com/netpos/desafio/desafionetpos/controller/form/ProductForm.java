package br.com.netpos.desafio.desafionetpos.controller.form;




import javax.validation.constraints.NotNull;


import br.com.netpos.desafio.desafionetpos.model.Product;
import br.com.netpos.desafio.desafionetpos.model.UserAccount;

public class ProductForm {

	@NotNull 
	private String code;
	@NotNull 
	private String name;
	@NotNull 
	private String price;
	@NotNull
	private int stock;
	@NotNull 
	private UserAccount user;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public UserAccount getUser() {
		return user;
	}
	public void setUser(UserAccount user) {
		this.user = user;
	}
	public Product converter() {
		return new Product(code, name, price, stock, user);
	}
	
}
