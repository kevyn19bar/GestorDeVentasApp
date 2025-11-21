package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;

public interface WarehousesServicio {
	
	List<Warehouses> GitAllWarehouses();
	
	Warehouses getWarehousById(Long id);
	
	void saveOrUpdateWarehous(Warehouses warehous);
	
	void deleteWarehous(Long id);

}