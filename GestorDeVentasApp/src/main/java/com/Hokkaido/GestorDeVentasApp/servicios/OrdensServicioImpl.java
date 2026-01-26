package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Orders;
import com.Hokkaido.GestorDeVentasApp.repositorios.OrdesRepositorio;

@Service
public class OrdensServicioImpl implements OrdensServicio {
	
	@Autowired
	private OrdesRepositorio ordesRepositorio;
	
	@Override
	public List<Orders> getAllOrders(){		
		return ordesRepositorio.findAll();
	}
	
	@Override
	public Orders getOrderById(Long id) {
		Optional<Orders> optionalinventori = ordesRepositorio.findById(id);
		if (optionalinventori.isPresent()) {
			return optionalinventori.get();
		} else {
			throw new RuntimeException("Order not found with ID: " + id);
		}
	}
	
	@Override
	public void saveOrUpdateOrder(Orders orders ) {
		ordesRepositorio.save(orders);
	}
	
	@Override
	public void deleteOrder(Long id) {
		ordesRepositorio.deleteById(id);
	}
	

}
