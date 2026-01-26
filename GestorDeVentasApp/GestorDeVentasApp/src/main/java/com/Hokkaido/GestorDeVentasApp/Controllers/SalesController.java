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

import com.Hokkaido.GestorDeVentasApp.entidades.Sales;
import com.Hokkaido.GestorDeVentasApp.servicios.SalesServicio;

@Controller
public class SalesController {
    
    @Autowired
    private SalesServicio salesServicio;

    @GetMapping("/listSales")
    public String getAllSales(Model model) {
        try {
            List<Sales> listSales = salesServicio.getAllSales();
            model.addAttribute("Sales", listSales);
        } catch (Exception e) {
            System.out.println("Error retrieving sales: " + e.getMessage());
        }
        return "/entities/sale/Sales";
    }

    @GetMapping("/addSale")
    public String showAddForm(Model model) {
        try {
            model.addAttribute("sale", new Sales());
        } catch (Exception e) {
            System.out.println("Error preparing add form: " + e.getMessage());
        }
        return "/entities/sale/AddSale";
    }

    @GetMapping("/editSale/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {
            Sales sale = salesServicio.getSaleById(id);
            model.addAttribute("sale", sale);
        } catch (Exception e) {
            System.out.println("Error retrieving sale for edit: " + e.getMessage());
            return "redirect:/listSales";
        }
        return "/entities/sale/EditSale";
    }

    @PostMapping("/saveSale")
    public String saveSale(@ModelAttribute("sale") Sales sale, RedirectAttributes redirectAttributes) {
        boolean isNew = (sale.getSale_id() == null);
        try {
            salesServicio.saveOrUpdateSale(sale);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Sale successfully added.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Sale successfully updated.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving sale: " + e.getMessage());
        }
        return "redirect:/listSales";
    }

    @GetMapping("/delSale/{id}")
    public String deleteSale(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            salesServicio.deleteSale(id);
            redirectAttributes.addFlashAttribute("successMessage", "Sale ID " + id + " successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting sale ID " + id + ": " + e.getMessage());
        }
        return "redirect:/listSales";
    }

}
