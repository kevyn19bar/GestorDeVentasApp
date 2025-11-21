package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;
import com.Hokkaido.GestorDeVentasApp.repositorios.InventoriesRepositorio;

@Service
public class InventoriesServicioImpl implements InventoriesServicio{

	@Autowired
	private InventoriesRepositorio inventoriesRepositorio ;
	
	@Override
	public List<Inventories> getAllInventories() {
		return inventoriesRepositorio.findAll();
	}
	
	@Override
	public Inventories getInventoriById(Long id) {
		Optional<Inventories> optionalinventori = inventoriesRepositorio.findById(id);
		if (optionalinventori.isPresent()) {
			return optionalinventori.get();
		} else {
			throw new RuntimeException("Invetori not found with ID: " + id);
		}
	}
	
	@Override
	public void saveOrUpdataInventori(Inventories inventories ) {
		inventoriesRepositorio.save(inventories);
	}
	
	@Override
	public void deleteInventori(Long id) {
		inventoriesRepositorio.deleteById(id);
	}

}
