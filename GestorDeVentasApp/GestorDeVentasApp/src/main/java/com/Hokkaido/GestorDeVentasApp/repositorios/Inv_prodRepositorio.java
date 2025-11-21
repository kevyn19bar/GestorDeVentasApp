package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Inv_prod;

@Repository
public interface Inv_prodRepositorio extends JpaRepository<Inv_prod, Long>{
	

}
