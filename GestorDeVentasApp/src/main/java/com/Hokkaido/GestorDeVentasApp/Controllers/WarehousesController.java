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

import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;
import com.Hokkaido.GestorDeVentasApp.entidades.Locations;
import com.Hokkaido.GestorDeVentasApp.entidades.Managers;
import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;
import com.Hokkaido.GestorDeVentasApp.servicios.InventoriesServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.LocationsServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.ManagersServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.WarehousesServicio;

@Controller
public class WarehousesController {
	@Autowired
	private WarehousesServicio warehousesServicio;
	
	@Autowired
	private LocationsServicio locationsServicio;
	
	@Autowired
	private ManagersServicio managersServicio;
	
	@Autowired
	private InventoriesServicio inventoriesServicio;
	
	@GetMapping("/listWareho")
	public String getAllAssistants (Model model) {
		try {
			List<Warehouses> listWarehouses = warehousesServicio.GitAllWarehouses();
			model.addAttribute("Warehouses", listWarehouses);
			
			List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventaries", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
	        
	        List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/warehouse/Warehouses";
	}
	
	@GetMapping("/addWareho")
	public String showAddForn(Model model) {
		model.addAttribute("warehous", new Warehouses());
		try {
			
			List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventaries", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
	        
	        List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/warehouse/AddWareho";
	}
	
    @GetMapping("/editWare/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
        	Warehouses warehous =warehousesServicio.getWarehousById(id);
            model.addAttribute("warehous", warehous);
            
            List<Inventories> listInventories = inventoriesServicio.getAllInventories();
	        model.addAttribute("Inventaries", listInventories);
	        
	        List<Locations> listLocations = locationsServicio.getAllLocations();
	        model.addAttribute("Locations", listLocations);
	        
	        List<Managers> listManager = managersServicio.getAllManagers();
			model.addAttribute("Managers",listManager);
			
        } catch (Exception e) {
            System.out.println("Error getting editing warehous: " + e.getMessage());
            return "redirect:/listWareho";
        }
        return "/entities/warehouse/EditWareho";
    }

    @PostMapping("/saveWareho")
    public String saveWarehous(@ModelAttribute("warehous") Warehouses warehous, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (warehous.getWarehouse_id() == null); 
        try {
        	warehousesServicio.saveOrUpdateWarehous(warehous);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added warehous.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated warehous.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving warehous: " + e.getMessage());
        }
        
        return "redirect:/listWareho";
    }

    @GetMapping("/delWare/{id}")
    public String deleteWarehous(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
        	warehousesServicio.deleteWarehous(id);
            redirectAttributes.addFlashAttribute("successMessage", "warehous ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting warehous ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listWareho";
    }
}