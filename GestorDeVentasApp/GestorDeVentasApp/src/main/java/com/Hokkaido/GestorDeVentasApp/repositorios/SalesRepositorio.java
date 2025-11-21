package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Sales;

@Repository
public interface SalesRepositorio extends JpaRepository<Sales, Long>{
	

}
