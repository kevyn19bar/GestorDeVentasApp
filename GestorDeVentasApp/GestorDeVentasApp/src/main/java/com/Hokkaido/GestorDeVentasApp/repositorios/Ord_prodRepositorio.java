package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Ord_prod;

@Repository
public interface Ord_prodRepositorio extends JpaRepository<Ord_prod, Long>{
	
	
}
