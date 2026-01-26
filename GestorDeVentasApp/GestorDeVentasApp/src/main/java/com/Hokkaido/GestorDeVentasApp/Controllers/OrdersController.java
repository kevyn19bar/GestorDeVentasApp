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

import com.Hokkaido.GestorDeVentasApp.entidades.Orders;

import com.Hokkaido.GestorDeVentasApp.servicios.OrdensServicio;

@Controller
public class OrdersController {
	
	@Autowired
	private OrdensServicio ordensServicio;
	
	@GetMapping("/listOrders")
	public String getAllAssistants(Model model) {
		try {
			List<Orders> lisOrders = ordensServicio.getAllOrders();
			model.addAttribute("Orders", lisOrders);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/order/Orders";
	}
	
	@GetMapping("/addOrder")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("order", new Orders());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/order/AddOrder";
	}
    @GetMapping("/editOrder/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
            Orders orders = ordensServicio.getOrderById(id);            
            model.addAttribute("order", orders);
        } catch (Exception e) {
            System.out.println("Error getting editing order: " + e.getMessage());
            return "redirect:/listOrder";
        }
        return "/entities/order/EditOrder";
    }
    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Orders orders, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (orders.getOrder_id() == null); 
        try {
        	ordensServicio.saveOrUpdateOrder(orders);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added order.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated order.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving order: " + e.getMessage());
        }
        
        return "redirect:/listOrders";
    }
    @GetMapping("/delOrder/{id}")
    public String deleteInvetori(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
        	ordensServicio.deleteOrder(id);
            redirectAttributes.addFlashAttribute("successMessage", "orders ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting order ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listOrders";
    }
	

}
