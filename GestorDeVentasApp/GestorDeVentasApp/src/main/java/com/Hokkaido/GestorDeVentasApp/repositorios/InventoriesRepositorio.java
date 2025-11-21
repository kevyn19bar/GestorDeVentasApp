package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;

@Repository
public interface InventoriesRepositorio extends JpaRepository<Inventories, Long>{
	

}
