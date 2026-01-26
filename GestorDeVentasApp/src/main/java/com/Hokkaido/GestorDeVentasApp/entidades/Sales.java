package com.Hokkaido.GestorDeVentasApp.entidades;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sale_id;
	
	private Long branch_id;
	private int quantity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;
	
	private Double tax;
	private Double subtotal;
	private Double discount;
	private Double value;
	
	public Sales() {
		super();
	}

	public Long getSale_id() {
		return sale_id;
	}

	public void setSale_id(Long sale_id) {
		this.sale_id = sale_id;
	}

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public Date getSaleDate() { 
		return saleDate; }
	
    public void setSaleDate(Date saleDate) { 
    	this.saleDate = saleDate; }
    
    @PrePersist
    protected void onCreate() {
        if (this.saleDate == null) { this.saleDate = new Date(); }
    }
}
