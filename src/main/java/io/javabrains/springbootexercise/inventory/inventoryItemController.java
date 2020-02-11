package io.javabrains.springbootexercise.inventory;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/inventory")
public class inventoryItemController {
	
	@Autowired
	private InventoryItemService inventoryItemService;
	
	@GetMapping("/")
	@ApiOperation(value="Gets all of the items",response=InventoryItem.class)
	public List<InventoryItem> getAllInventoryItems(){
		return inventoryItemService.getAllInventoryItems();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Gets an item by id",notes="Supply the item number",response=InventoryItem.class)
	public InventoryItem getInventoryItem(@ApiParam(value="item number", required=true) @PathVariable int id){
		return inventoryItemService.getInventoryItem(id);
	}
	
	@PostMapping("/")
	@ApiOperation(value="Adds an item to the inventory",notes="Supply a json data of an inventory item")
	public void addInventoryItem(@RequestBody InventoryItem inventoryItem){
		inventoryItemService.addInventoryItem(inventoryItem);
	}
	
	@PutMapping("/")
	@ApiOperation(value="Update an item's quantity in the inventory",notes="Supply a json data of an inventory item with the same id of the item you want to change, negative amount will withdraw, positive amount will deposit")
	public void updateInventoryItemQuantity(@RequestBody InventoryItem inventoryItem){
		inventoryItemService.updateInventoryItemQuantity(inventoryItem);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="Deletes an item's quantity from the inventory")
	public void deleteInventoryItem(@ApiParam(value="item number", required=true) @PathVariable int id){
		inventoryItemService.deleteInventoryItem(id);
	}
}
