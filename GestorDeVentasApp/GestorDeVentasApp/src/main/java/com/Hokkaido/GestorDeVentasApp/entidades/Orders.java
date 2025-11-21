package com.Hokkaido.GestorDeVentasApp.entidades;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	private Double value;
	private Double tax;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_order;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_delivered;
	
	private Long supplier_id;
	private Long branch_id;
	
	public Orders() {
		super();
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Date getDate_order() {
		return date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}

	public Date getDate_delivered() {
		return date_delivered;
	}

	public void setDate_delivered(Date date_delivered) {
		this.date_delivered = date_delivered;
	}

	public Long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}
	
	
}
