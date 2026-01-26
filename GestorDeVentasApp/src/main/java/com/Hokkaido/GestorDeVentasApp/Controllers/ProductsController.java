package com.Hokkaido.GestorDeVentasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hokkaido.GestorDeVentasApp.entidades.Products;
import com.Hokkaido.GestorDeVentasApp.entidades.Suppliers;
import com.Hokkaido.GestorDeVentasApp.servicios.ProductsServicio;
import com.Hokkaido.GestorDeVentasApp.servicios.SuppliersServicio;

@Controller
public class ProductsController {

    @Autowired
    private ProductsServicio productsServicio;
    
    @Autowired
	private SuppliersServicio suppliersServicio;

    @GetMapping("/listProducts")
    public String listProducts(Model model) {
        try {
            List<Products> listProducts = productsServicio.getAllProducts();
            model.addAttribute("Products", listProducts);
            
            List<Suppliers> listSupplier = suppliersServicio.GitAllSuppliers();
	        model.addAttribute("Suppliers", listSupplier);
	        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return "/entities/product/Products";
    }

    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
    	List<Suppliers> listSuppliers = suppliersServicio.GitAllSuppliers();
    	model.addAttribute("supplier", listSuppliers);
    	model.addAttribute("categorias", Products.Tipoproduct.values());
        model.addAttribute("product", new Products());
        return "/entities/product/AddProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Products product = productsServicio.getProductById(id);
        model.addAttribute("product", product);
        List<Suppliers> listSupplier = suppliersServicio.GitAllSuppliers();
        model.addAttribute("categorias", Products.Tipoproduct.values());
        model.addAttribute("supplier", listSupplier);
        
        return "/entities/product/EditProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Products product, RedirectAttributes redirectAttributes) {
        boolean isNew = (product.getProduct_id() == null);
        productsServicio.saveOrUpdateProduct(product);
        if (isNew)
            redirectAttributes.addFlashAttribute("successMessage", "Product added successfully!");
        else
            redirectAttributes.addFlashAttribute("successMessage", "Product updated successfully!");
        return "redirect:/listProducts";
    }

    @GetMapping("/delProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productsServicio.deleteProduct(id);
        redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully!");
        return "redirect:/listProducts";
    }
}
