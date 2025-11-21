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

import com.Hokkaido.GestorDeVentasApp.entidades.Managers;
import com.Hokkaido.GestorDeVentasApp.servicios.ManagersServicio;

@Controller
public class ManagersController {
	
	@Autowired
	private ManagersServicio managersServicio;
	
	@GetMapping("/listManager")
	public String getAllAssistants(Model model) {
		try {
			List<Managers> listManagers = managersServicio.getAllManagers();
			model.addAttribute("Managers", listManagers);
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/manager/Managers";
	}
	
	@GetMapping("/addManager")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("manager", new Managers());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/manager/AddManager";
	}
    @GetMapping("/editManager/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
            Managers managers = managersServicio.getManagerById(id);            
            model.addAttribute("manager", managers);
        } catch (Exception e) {
            System.out.println("Error getting editing manager: " + e.getMessage());
            return "redirect:/listManager";
        }
        return "/entities/manager/EditManager";
    }
    @PostMapping("/saveManager")
    public String saveManager(@ModelAttribute("manager") Managers managers, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (managers.getManager_id() == null); 
        try {
        	managersServicio.saveOrUpdateManager(managers);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added manager.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated manager.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving manager: " + e.getMessage());
        }
        
        return "redirect:/listManager";
    }
    @GetMapping("/delManager/{id}")
    public String deleteInvetori(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
        	managersServicio.deleteManager(id);
            redirectAttributes.addFlashAttribute("successMessage", "managers ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting manager ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listManager";
    }
	
	

}
