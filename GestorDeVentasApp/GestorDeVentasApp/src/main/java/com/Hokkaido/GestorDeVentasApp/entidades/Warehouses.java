package com.Hokkaido.GestorDeVentasApp.entidades;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Warehouses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warehouse_id;
	
	private String warehouse_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Locations location_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Managers manager_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Inventories inventory_id;
	
	public Warehouses() {
		super();
	}

	public Long getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Long warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	public Locations getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Locations location_id) {
		this.location_id = location_id;
	}

	public Managers getManager_id() {
		return manager_id;
	}

	public void setManager_id(Managers manager_id) {
		this.manager_id = manager_id;
	}

	public Inventories getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Inventories inventory_id) {
		this.inventory_id = inventory_id;
	}
	
    public Long getLocationIdValue() {
        return (location_id != null) ? location_id.getLocation_id() : null;
    }

    public Long getManagerIdValue() {
        return (manager_id != null) ? manager_id.getManager_id() : null;
    }
    
    public Long getInventoryIdValue() {
        return (inventory_id != null) ? inventory_id.getInventory_id() : null;
    }

}
