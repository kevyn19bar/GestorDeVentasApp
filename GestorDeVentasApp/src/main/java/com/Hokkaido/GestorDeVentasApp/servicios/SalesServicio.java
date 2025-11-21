package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;

import com.Hokkaido.GestorDeVentasApp.entidades.Sales;

public interface SalesServicio {
		
	/** Obtiene todas las ventas */
    List<Sales> getAllSales();                       //se corrigio esta linea , estaba como "gitAllsales()"

    /** Obtiene una venta por su ID */
    Sales getSaleById(Long id);

    /** Guarda o actualiza una venta */
    void saveOrUpdateSale(Sales sale);

    /** Elimina una venta por su ID */
    void deleteSale(Long id);
  
}



