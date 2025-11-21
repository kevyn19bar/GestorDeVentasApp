package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Branches;
import com.Hokkaido.GestorDeVentasApp.repositorios.BranchesRepositorio;

@Service
public class BranchesServicioImpl implements BranchesServicio{

	@Autowired
	private BranchesRepositorio branchesRepositorio ;
	
	@Override
	public List<Branches> GetAllBranches() {
		return branchesRepositorio.findAll();
	}
	
	@Override
	public Branches getBranchById(Long id) {
		Optional<Branches> optionalBranch = branchesRepositorio.findById(id);
		if (optionalBranch.isPresent()) {
			return optionalBranch.get();
		} else {
			throw new RuntimeException("Branch not found with ID: " + id);
		}
	}
	
	@Override
	public void saveOrUpdateBranch(Branches branch ) {
		branchesRepositorio.save(branch);
	}
	
	@Override
	public void deleteBranch(Long id) {
		branchesRepositorio.deleteById(id);
	}

}
