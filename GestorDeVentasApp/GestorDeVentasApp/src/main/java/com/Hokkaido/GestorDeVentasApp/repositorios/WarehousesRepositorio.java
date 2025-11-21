package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;

@Repository
public interface WarehousesRepositorio extends JpaRepository<Warehouses, Long>{
	

}
