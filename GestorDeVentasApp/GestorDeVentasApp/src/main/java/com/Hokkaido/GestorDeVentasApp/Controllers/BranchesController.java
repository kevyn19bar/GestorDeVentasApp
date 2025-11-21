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
import com.Hokkaido.GestorDeVentasApp.servicios.BranchesServicio;

@Controller
public class BranchesController {
	
	@Autowired
	private BranchesServicio branchesServicio;
	
	@GetMapping("/listBranch")
	public String getAllBranches(Model model) {
		try {
			List<Branches> listBranches = branchesServicio.GetAllBranches();
			model.addAttribute("Branches", listBranches);
		}
		catch(Exception e) {
			System.out.println("Error listing branches: "+ e.getMessage());
			model.addAttribute("errorMessage", "The branches could not be loaded.");
		}
		return "/entities/branch/Branches";
	}
	@GetMapping("/addBranch")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("branch", new Branches());
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
        } catch (Exception e) {
            System.out.println("Error getting editing wizard: " + e.getMessage());
            return "redirect:/listAssist";
        }
        return "/entities/branch/EditBranch";
    }
    @PostMapping("/savebranch")
    public String saveBranch(@ModelAttribute("branch") Branches branches, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (branches.getBranch_id() == null); 
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
