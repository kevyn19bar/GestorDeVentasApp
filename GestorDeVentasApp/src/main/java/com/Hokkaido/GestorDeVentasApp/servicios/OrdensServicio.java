package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Orders;

public interface OrdensServicio {
	
	List<Orders>getAllOrders();
	
	Orders getOrderById(Long id);
	
	void saveOrUpdateOrder(Orders Orders);

	void deleteOrder(Long id);

	
}
