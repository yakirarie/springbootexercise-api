package io.javabrains.springbootexercise.inventory;

import org.springframework.data.repository.CrudRepository;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer>{
	
}
