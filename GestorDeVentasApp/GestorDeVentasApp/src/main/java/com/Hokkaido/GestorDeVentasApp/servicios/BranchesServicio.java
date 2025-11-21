package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import com.Hokkaido.GestorDeVentasApp.entidades.Branches;

public interface BranchesServicio {

	List<Branches> GetAllBranches();
	
	Branches getBranchById(Long id);
	
	void saveOrUpdateBranch(Branches branches);
	
	void deleteBranch(Long id);
}