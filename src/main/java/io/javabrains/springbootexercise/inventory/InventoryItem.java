package io.javabrains.springbootexercise.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Details about inventory item")
public class InventoryItem {
	
	@Id
	@ApiModelProperty(notes="Uinque item number")
	private int itemNo;
	
	@ApiModelProperty(notes="Item's name")
	private String name;
	
	@ApiModelProperty(notes="Amount of an item")
	private int amount;
	
	@ApiModelProperty(notes="Item's inventory code")
	private String inventoryCode;

	
	public InventoryItem(){
		
	}
	
	public InventoryItem(int itemNo, String name, int amount, String inventoryCode) {
		super();
		this.itemNo = itemNo;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}

	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getInventoryCode() {
		return inventoryCode;
	}


	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}


}
