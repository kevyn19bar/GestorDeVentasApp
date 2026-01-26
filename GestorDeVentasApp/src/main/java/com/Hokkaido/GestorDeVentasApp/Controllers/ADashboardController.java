package com.Hokkaido.GestorDeVentasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Hokkaido.GestorDeVentasApp.entidades.Orders;
import com.Hokkaido.GestorDeVentasApp.entidades.Products;
import com.Hokkaido.GestorDeVentasApp.entidades.Sales;
import com.Hokkaido.GestorDeVentasApp.entidades.Suppliers;
import com.Hokkaido.GestorDeVentasApp.servicios.OrdensServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.ProductsServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.SalesServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.SuppliersServicio;

@Controller
public class ADashboardController {

    @Autowired
    private ProductsServicio productsServicio;
    
    @Autowired
    private SalesServicio salesServicio;
    
    @Autowired
    private OrdensServicio ordensServicio;
    
    @Autowired
    private SuppliersServicio suppliersServicio;

    @GetMapping("/")
    public String showDashboard(Model model) {
        
        // 1. Obtener listas
        List<Products> products = productsServicio.getAllProducts();
        List<Sales> sales = salesServicio.getAllSales();
        List<Orders> orders = ordensServicio.getAllOrders();
        List<Suppliers> suppliers = suppliersServicio.GitAllSuppliers();
        
        // 2. Calcular KPIs (Contadores)
        model.addAttribute("totalProducts", products.size());
        model.addAttribute("totalOrders", orders.size());
        model.addAttribute("totalSuppliers", suppliers.size());
        
        // 3. Calcular Total Vendido (Suma de Sales.value)
        double totalEarnings = 0.0;
        for (Sales sale : sales) {
            if (sale.getValue() != null) {
                totalEarnings += sale.getValue();
            }
        }
        model.addAttribute("totalEarnings", totalEarnings);
        
        // 4. Datos para el Gráfico (Ejemplo simple: Pasar las ventas recientes)
        // Nota: En un sistema real, harías una consulta SQL para agrupar por fecha.
        // Aquí pasamos el tamaño para simplificar el ejemplo visual.
        model.addAttribute("salesCount", sales.size());

        return "/entities/index"; // Asegúrate de que tu vista principal se llame index.html
    }
}