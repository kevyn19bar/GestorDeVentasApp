package com.Hokkaido.GestorDeVentasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hokkaido.GestorDeVentasApp.entidades.Branches;
import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;
import com.Hokkaido.GestorDeVentasApp.entidades.Locations;
import com.Hokkaido.GestorDeVentasApp.entidades.Managers;
import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;
import com.Hokkaido.GestorDeVentasApp.servicios.BranchesServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.InventoriesServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.LocationsServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.ManagersServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.WarehousesServicio;

@Controller
public class BranchesController {
	
	@Autowired
	private BranchesServicio branchesServicio;
	
	@Autowired
	private ManagersServicio managersServicio;
	
	@Autowired
	private WarehousesServicio warehousesServicio;
	
	@Autowired
	private InventoriesServicio inventoriesServicio;
	
	@Autowired
	private LocationsServicio locationsServicio;
	
	@GetMapping("/listBranch")
	public String getAllBranches(Model model) {
		try {
			List<Branches> listBranches = branchesServicio.GetAllBranches();
			model.addAttribute("Branches", listBranches);
			
			List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
			List<Warehouses> listWarehouses = warehousesServicio.GitAllWarehouses();
	        model.addAttribute("Warehouses", listWarehouses);
	        
	        List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventaries", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
	        
		}
		catch(Exception e) {
			System.out.println("Error listing branches: "+ e.getMessage());
			model.addAttribute("errorMessage", "The branches could not be loaded.");
		}
		return "/entities/branch/Branches";
	}
	@GetMapping("/addBranch")
	public String showAddForn(Model model) {
		model.addAttribute("branch", new Branches());
		try {
			List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
			List<Warehouses> listWarehouses = warehousesServicio.GitAllWarehouses();
	        model.addAttribute("Warehouses", listWarehouses);
	        
	        List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventories", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/branch/AddBranch";
	}
    @GetMapping("/editBranch/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
            Branches branch = branchesServicio.getBranchById(id);            
            model.addAttribute("branch", branch);
            
            List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
			List<Warehouses> listWarehouses = warehousesServicio.GitAllWarehouses();
	        model.addAttribute("Warehouses", listWarehouses);
	        
	        List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventories", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
        } catch (Exception e) {
            System.out.println("Error getting editing wizard: " + e.getMessage());
            return "redirect:/listAssist";
        }
        return "/entities/branch/EditBranch";
    }
    @PostMapping("/savebranch")
    public String saveBranch(@ModelAttribute("branch") Branches branches, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (branches.getBranch_id() == null); 
        System.out.println(branches.getBranch_name());
        try {
            branchesServicio.saveOrUpdateBranch(branches);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added branch.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated branch.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving branch: " + e.getMessage());
        }
        
        return "redirect:/listBranch";
    }
    @GetMapping("/delBranch/{id}")
    public String deleteBranch(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            branchesServicio.deleteBranch(id);
            redirectAttributes.addFlashAttribute("successMessage", "branches ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting branch ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listBranch";
    }
}
