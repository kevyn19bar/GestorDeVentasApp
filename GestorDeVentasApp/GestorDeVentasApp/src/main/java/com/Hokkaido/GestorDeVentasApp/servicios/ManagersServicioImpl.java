package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Managers;
import com.Hokkaido.GestorDeVentasApp.repositorios.ManagersRepositorio;

@Service
public class ManagersServicioImpl implements ManagersServicio{
	
	@Autowired
	private ManagersRepositorio managersRepositorio;

	@Override
	public List<Managers> getAllManagers() {
		return managersRepositorio.findAll();
	}
	
	@Override
	public Managers getManagerById(Long id) {
		Optional<Managers> optionalinventori = managersRepositorio.findById(id);
		if (optionalinventori.isPresent()) {
			return optionalinventori.get();
		} else {
			throw new RuntimeException("Manager not found with ID: " + id);
		}
	}
	
	@Override
	public void saveOrUpdateManager(Managers managers ) {
		managersRepositorio.save(managers);
	}
	
	@Override
	public void deleteManager(Long id) {
		managersRepositorio.deleteById(id);
	}
	
}
