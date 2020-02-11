package io.javabrains.springbootexercise.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryItemService {
	
	@Autowired
	private InventoryItemRepository inventoryItemRep;	
	
	public List<InventoryItem> getAllInventoryItems(){
		List<InventoryItem> inventoryItems = new ArrayList<>();
		inventoryItemRep.findAll().forEach(inventoryItems::add);
		return inventoryItems;
		
	}
	
	public InventoryItem getInventoryItem(int id){
		return inventoryItemRep.findOne(id);
	}
	
	public void addInventoryItem(InventoryItem inventoryItem){
		inventoryItemRep.save(inventoryItem);
	}
	
	public void updateInventoryItemQuantity(InventoryItem inventoryItem){
		InventoryItem oldItem = inventoryItemRep.findOne(inventoryItem.getItemNo());
		oldItem.setAmount(Math.max(oldItem.getAmount() + inventoryItem.getAmount(), 0));
		inventoryItemRep.save(oldItem);
	}
	
	public void deleteInventoryItem(int id){
		inventoryItemRep.delete(id);
	}
	
}
