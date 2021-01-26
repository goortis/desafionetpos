package br.com.netpos.desafio.desafionetpos.controller.form;


import javax.validation.constraints.NotNull;



import br.com.netpos.desafio.desafionetpos.model.Product;
import br.com.netpos.desafio.desafionetpos.repository.ProductRepository;

public class UpdateProductForm {
	
	@NotNull
	private String code;
	@NotNull
	private String name;
	@NotNull
	private String price;
	@NotNull
	private int stock;
	
	
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
	public Product update(Long id, ProductRepository productRepository) {
		Product product = productRepository.getOne(id);
		product.setCode(this.code);
		product.setName(this.name);
		product.setPrice(this.price);
		product.setStock(this.stock);
		return product;
	}
	
	
	
}
