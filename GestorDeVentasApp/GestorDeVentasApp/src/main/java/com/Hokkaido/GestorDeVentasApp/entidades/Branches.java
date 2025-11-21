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
public class Branches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branch_id;
	
	private String branch_name;
	private String contact_name;
	private int employee_count;
	private String branch_address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Managers manager_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "warehouse_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Warehouses warehouse_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Inventories inventory_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Locations location_id;
	
	public Branches() {
		super();
	}

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public int getEmployee_count() {
		return employee_count;
	}

	public void setEmployee_count(int employee_count) {
		this.employee_count = employee_count;
	}

	public String getBranch_address() {
		return branch_address;
	}

	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}

	public Managers getManager_id() {
		return manager_id;
	}

	public void setManager_id(Managers manager_id) {
		this.manager_id = manager_id;
	}

	public Warehouses getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Warehouses warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public Inventories getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Inventories inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Locations getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Locations location_id) {
		this.location_id = location_id;
	}

	public Long getManagerIdValue() {
		return (manager_id != null) ? manager_id.getManager_id(): null;
	}
	
    public Long getWarehouseIdValue() {
        return (warehouse_id != null) ? warehouse_id.getWarehouse_id() : null;
    }
    
    public Long getInventoryIdValue() {
    	return (inventory_id != null) ? inventory_id.getInventory_id():null;
    }
    
    public Long getlocationIdValue() {
    	return (location_id != null) ? location_id.getLocation_id(): null;
    }
}
