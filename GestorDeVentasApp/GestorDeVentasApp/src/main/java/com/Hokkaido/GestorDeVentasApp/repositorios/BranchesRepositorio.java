package com.Hokkaido.GestorDeVentasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hokkaido.GestorDeVentasApp.entidades.Branches;

@Repository
public interface BranchesRepositorio extends JpaRepository<Branches, Long>{
	

}
