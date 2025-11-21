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

import com.Hokkaido.GestorDeVentasApp.entidades.Warehouses;
import com.Hokkaido.GestorDeVentasApp.servicios.WarehousesServicio;

@Controller
public class WarehousesController {
	@Autowired
	private WarehousesServicio warehousesServicio;
	
	@GetMapping("/listWareho")
	public String getAllAssistants (Model model) {
		try {
			List<Warehouses> listWarehouses = warehousesServicio.GitAllWarehouses();
			model.addAttribute("Warehouses", listWarehouses);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/warehouse/Warehouses";
	}
	
	@GetMapping("/addWareho")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("warehous", new Warehouses());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/warehouse/AddWareho";
	}
	
    @GetMapping("/editWareho/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
        	Warehouses warehous =warehousesServicio.getWarehousById(id);
            model.addAttribute("warehous", warehous);
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

    @GetMapping("/delWareho/{id}")
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