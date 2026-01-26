package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Suppliers;

public interface SuppliersServicio {
	
	List<Suppliers> GitAllSuppliers();
	
	Suppliers getSupplierById(Long id);
	
	void saveOrUpdataSupplier(Suppliers suppliers);
	
	void deleteSupplier(Long id);
}