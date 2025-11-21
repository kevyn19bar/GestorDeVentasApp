package com.Hokkaido.GestorDeVentasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Hokkaido.GestorDeVentasApp.entidades.Inventories;
import com.Hokkaido.GestorDeVentasApp.entidades.Orders;
import com.Hokkaido.GestorDeVentasApp.entidades.Products;
import com.Hokkaido.GestorDeVentasApp.entidades.Sales;
import com.Hokkaido.GestorDeVentasApp.servicios.InventoriesServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.OrdensServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.ProductsServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.SalesServicio;

@Controller
public class AReportesController {
	
	@Autowired
    private ProductsServicio productService;

    @Autowired
    private InventoriesServicio inventoryService;

    @Autowired
    private OrdensServicio orderService;

    @Autowired
    private SalesServicio saleService;
    
    @GetMapping("/Reports")
    public String verReportes(Model model) {
    	try {
    		List<Products> listProducts = productService.getAllProducts();
            model.addAttribute("Products", listProducts);
            
            List<Inventories> listInventories = inventoryService.getAllInventories();
	        model.addAttribute("Inventories", listInventories);
	        
	        List<Orders> lisOrders = orderService.getAllOrders();
			model.addAttribute("Orders", lisOrders);
			
			List<Sales> listSales = saleService.getAllSales();
            model.addAttribute("Sales", listSales);
			
		} catch (Exception e) {
			 System.out.println("Error retrieving sales: " + e.getMessage());
		}
        return "/entities/reports";
    }
}
