package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Sales;

public interface SalesServicio {
		
    List<Sales> getAllSales();                       //se corrigio esta linea , estaba como "gitAllsales()"

    Sales getSaleById(Long id);

    void saveOrUpdateSale(Sales sale);

    void deleteSale(Long id);
  
}