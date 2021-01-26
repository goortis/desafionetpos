package br.com.netpos.desafio.desafionetpos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.netpos.desafio.desafionetpos.model.Product;
import br.com.netpos.desafio.desafionetpos.model.UserAccount;

public class ProductDto {

	private Long id;
	private String code;
	private String name;
	private String price;
	private int stock;
	private String user;
	
	public ProductDto(Product product) {
		this.id = product.getId();
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
		this.stock = product.getStock();
		this.user = product.getUserAccount().getName();
	}
	
	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}

	public String getUser() {
		return user;
	}


	public static List<ProductDto> converter(List<Product> product) {
		return product.stream().map(ProductDto::new).collect(Collectors.toList());
	}
}
