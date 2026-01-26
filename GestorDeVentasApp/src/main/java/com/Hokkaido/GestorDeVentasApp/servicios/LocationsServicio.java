package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Locations;

public interface LocationsServicio {
	
	List<Locations> getAllLocations();
	
	Locations getLocationById(Long id);
	
	void saveOrUpdateLocation(Locations Locations);

	void deleteLocation(Long id);
}
