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

import com.Hokkaido.GestorDeVentasApp.entidades.Suppliers;
import com.Hokkaido.GestorDeVentasApp.servicios.SuppliersServicio;

@Controller
public class SuppliersController {
	@Autowired
	private SuppliersServicio suppliersServicio;
	
	@GetMapping("/listSuppl")
	private String getAllAssistants (Model model){
		try {
			List<Suppliers> lisSuppliers = suppliersServicio.GitAllSuppliers();
			model.addAttribute("Suppliers", lisSuppliers);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/supplier/Suppliers";
	}
	
	@GetMapping("/addSupplier")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("supplier", new Suppliers());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/supplier/AddSupplier";
	}
	
    @GetMapping("/editSupplier/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
        	Suppliers supplier = suppliersServicio.getSupplierById(id);
        	model.addAttribute("supplier", supplier);
        } catch (Exception e) {
            System.out.println("Error getting editing supplier: " + e.getMessage());
            return "redirect:/listSuppl";
        }
        return "/entities/supplier/EditSupplier";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("supplier") Suppliers supplier, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (supplier.getSupplier_id() == null); 
        try {
            suppliersServicio.saveOrUpdataSupplier(supplier);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added supplier.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated supplier.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving supplier: " + e.getMessage());
        }
        
        return "redirect:/listSuppl";
    }

    @GetMapping("/delSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            suppliersServicio.deleteSupplier(id);
            redirectAttributes.addFlashAttribute("successMessage", "supplier ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting supplier ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listSuppl";
    }
}
