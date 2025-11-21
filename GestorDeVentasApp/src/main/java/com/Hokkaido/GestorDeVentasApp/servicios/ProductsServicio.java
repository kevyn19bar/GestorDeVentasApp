package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Products;

/**
 * Interfaz que define las operaciones disponibles para la gestión de productos.
 */
public interface ProductsServicio {
    List<Products> getAllProducts();
    Products getProductById(Long id);
    void saveOrUpdateProduct(Products product);
    void deleteProduct(Long id);
}