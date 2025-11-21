package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hokkaido.GestorDeVentasApp.entidades.Sales;
import com.Hokkaido.GestorDeVentasApp.repositorios.SalesRepositorio;

@Service
public class SalesServicioImpl implements SalesServicio {

    @Autowired
    private SalesRepositorio salesRepositorio;

    @Override
    public List<Sales> getAllSales() {                  //se corrigio el error, "gitAllSales()"
        return salesRepositorio.findAll();
    }

    @Override
    public Sales getSaleById(Long id) {
        return salesRepositorio.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdateSale(Sales sale) {
        salesRepositorio.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        salesRepositorio.deleteById(id);
    }
}
