package com.Hokkaido.GestorDeVentasApp.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Suppliers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplier_id;
	
	private String name;
	private String phone;
	private String email;
	
	public Suppliers() {
		super();
	}
	
	
	public Long getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
