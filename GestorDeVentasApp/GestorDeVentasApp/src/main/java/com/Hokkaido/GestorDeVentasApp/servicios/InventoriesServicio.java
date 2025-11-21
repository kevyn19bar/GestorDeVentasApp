package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;

public interface InventoriesServicio {

	List<Inventories> getAllInventories();
	
	Inventories getInventoriById(Long id);
	
	void saveOrUpdataInventori(Inventories inventories);

	void deleteInventori(Long id);
}