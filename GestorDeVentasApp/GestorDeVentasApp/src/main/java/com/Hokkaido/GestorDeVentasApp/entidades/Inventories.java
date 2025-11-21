package com.Hokkaido.GestorDeVentasApp.entidades;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventory_id;
	
	private String inventory_name;
	private Double capacity_volume;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creation_date;
	
	public Inventories() {
		super();
	}
	
	public Long getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Long inventory_id) {
		this.inventory_id = inventory_id;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}
	
	public Double getCapacity_volume() {
		return capacity_volume;
	}

	public void setCapacity_volume(Double capacity_volume) {
		this.capacity_volume = capacity_volume;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
}