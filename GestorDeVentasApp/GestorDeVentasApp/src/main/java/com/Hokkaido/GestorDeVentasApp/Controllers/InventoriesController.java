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
import com.Hokkaido.GestorDeVentasApp.servicios.InventoriesServicio;

@Controller
public class InventoriesController {
	
	@Autowired
	private InventoriesServicio inventoriesServicio;
	
	@GetMapping("/listInventory")
	public String getAllAssistants(Model model) {
		try {
			List<Inventories> listInventories = inventoriesServicio.getAllInventories();
			model.addAttribute("Inventories", listInventories);
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/inventory/Inventories";
	}
	@GetMapping("/addInventory")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("inventori", new Inventories());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/inventory/AddInventory";
	}
    @GetMapping("/editInventory/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
            Inventories inventories = inventoriesServicio.getInventoriById(id);            
            model.addAttribute("inventori", inventories);
        } catch (Exception e) {
            System.out.println("Error getting editing inventori: " + e.getMessage());
            return "redirect:/listInventory";
        }
        return "/entities/inventory/EditInventory";
    }
    @PostMapping("/saveinventori")
    public String saveInventori(@ModelAttribute("inventori") Inventories inventories, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (inventories.getInventory_id() == null); 
        try {
            inventoriesServicio.saveOrUpdataInventori(inventories);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added inventori.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated inventori.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving inventori: " + e.getMessage());
        }
        
        return "redirect:/listInventory";
    }
    @GetMapping("/delInventory/{id}")
    public String deleteInvetori(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            inventoriesServicio.deleteInventori(id);
            redirectAttributes.addFlashAttribute("successMessage", "inventories ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting inventori ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listInventory";
    }
}

