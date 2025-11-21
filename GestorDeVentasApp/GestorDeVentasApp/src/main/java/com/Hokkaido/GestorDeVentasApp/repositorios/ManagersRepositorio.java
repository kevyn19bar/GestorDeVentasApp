package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Managers;

@Repository
public interface ManagersRepositorio extends JpaRepository<Managers, Long>{
	

}
