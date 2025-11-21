package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Sales_prod;

@Repository
public interface Sales_prodRepositorio extends JpaRepository<Sales_prod, Long>{
	

}
