package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Locations;

import com.Hokkaido.GestorDeVentasApp.repositorios.LocationsRepositorio;

@Service
public class LocationsServicioImpl implements LocationsServicio{
	
	@Autowired
	private LocationsRepositorio locationsRepositorio;
	
	@Override
	public List<Locations> getAllLocations() {
		return locationsRepositorio.findAll();
	}
	@Override
	public Locations getLocationById(Long id) {
		Optional<Locations> optionalinventori = locationsRepositorio.findById(id);
		if (optionalinventori.isPresent()) {
			return optionalinventori.get();
		} else {
			throw new RuntimeException("Location not found with ID: " + id);
		}
	}
	
	@Override
	public void saveOrUpdateLocation(Locations locations ) {
		locationsRepositorio.save(locations);
	}
	
	@Override
	public void deleteLocation(Long id) {
		locationsRepositorio.deleteById(id);
	}

}
