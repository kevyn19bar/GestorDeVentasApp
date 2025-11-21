package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;
import com.Hokkaido.GestorDeVentasApp.repositorios.WarehousesRepositorio;

@Service
public class WarehousesServicioImpl implements WarehousesServicio{
	
	@Autowired
	private WarehousesRepositorio warehousesRepositorio;
	
	@Override
	public List<Warehouses> GitAllWarehouses(){
		return warehousesRepositorio.findAll();
	}

	@Override
	public Warehouses getWarehousById(Long id) {
		Optional<Warehouses> optionalwarehous = warehousesRepositorio.findById(id);
		if (optionalwarehous.isPresent()) {
			return optionalwarehous.get();
		}else {
			throw new RuntimeException("warehous not found with ID: " + id);
		}
	}

	@Override
	public void saveOrUpdateWarehous(Warehouses warehous) {
		warehousesRepositorio.save(warehous);
	}

	@Override
	public void deleteWarehous(Long id) {
		warehousesRepositorio.deleteById(id);
	}
	

}
