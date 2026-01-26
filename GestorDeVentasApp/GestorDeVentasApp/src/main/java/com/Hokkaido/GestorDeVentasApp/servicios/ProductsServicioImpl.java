package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Products;
import com.Hokkaido.GestorDeVentasApp.repositorios.ProductsRepositorio;

@Service
public class ProductsServicioImpl implements ProductsServicio {

    @Autowired
    private ProductsRepositorio productsRepositorio;

    @Override
    public List<Products> getAllProducts() {
        return productsRepositorio.findAll();
    }

    @Override
    public Products getProductById(Long id) {
        return productsRepositorio.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdateProduct(Products product) {
        productsRepositorio.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepositorio.deleteById(id);
    }
}
