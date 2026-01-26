package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Suppliers;
import com.Hokkaido.GestorDeVentasApp.repositorios.SuppliersRepositorio;

@Service
public class SuppliersServicioImpl implements SuppliersServicio{
	@Autowired
	private SuppliersRepositorio suppliersRepositorio;
	
	@Override
	public List<Suppliers> GitAllSuppliers(){
		return suppliersRepositorio.findAll();
	}

	@Override
	public Suppliers getSupplierById(Long id) {
		Optional<Suppliers> optinalSupplier = suppliersRepositorio.findById(id);
		if (optinalSupplier.isPresent()) {
			return optinalSupplier.get();
		}else {
			throw new RuntimeException("Supplier not found with ID: " + id);
		}
	}

	@Override
	public void saveOrUpdataSupplier(Suppliers suppliers) {
		suppliersRepositorio.save(suppliers);
	}

	@Override
	public void deleteSupplier(Long id) {
		suppliersRepositorio.deleteById(id);
	}
	

}
