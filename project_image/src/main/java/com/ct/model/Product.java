package com.ct.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + ", discount=" + discount + "]";
	}
	@Id @GeneratedValue
	private int id;
	public String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty(message="This field is Mandatory")
	@Size(min=3,max=16,message="name should be more than 3 & less than 16")
	private String name;
	
	
	@NotNull(message="This field is accept only integers")
	private Integer price;
	
	
	@NotNull(message="This field is accept only integers")
	private Integer quantity;
	
	@NotEmpty(message="This field is Mandatory")
	@Size(min=3,max=16,message="description should be more than 3 & less than 16")
	private String description;
	
	
	@NotNull(message="This field is accept only integers")
	private Integer discount;
	
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(int id, String name, Integer price, Integer quantity, String description,
			Integer discount, String image) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.discount = discount;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
