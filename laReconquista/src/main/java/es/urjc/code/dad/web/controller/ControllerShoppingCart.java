package es.urjc.code.dad.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.urjc.code.dad.web.entity.Category;
import es.urjc.code.dad.web.entity.Client;
import es.urjc.code.dad.web.entity.Item;
import es.urjc.code.dad.web.entity.Orders;
import es.urjc.code.dad.web.repository.CategoryRepository;
import es.urjc.code.dad.web.repository.ClientRepository;
import es.urjc.code.dad.web.repository.ItemRepository;
import es.urjc.code.dad.web.repository.OrdersRepository;

@Controller
public class ControllerShoppingCart {
	
	@Autowired private ClientRepository client;
	@Autowired private OrdersRepository orders;
	@Autowired private ItemRepository items;
	@Autowired private CategoryRepository category;
	
	@GetMapping("/cart/{name}/{nameItem}/{nameCategory}")
	public String carrito(Model model, @PathVariable String name,  @PathVariable String nameItem, @PathVariable String nameCategory) {
				
		Client c = client.findByName(name);
		Category cate = category.findByNameCategory(nameCategory);
		List <Item> aux = new ArrayList<Item>(cate.getItems());
		Item itemAux = items.findByNameItem(nameItem);
		
		if(c.getCarrito().contains(nameItem) == false) {
			c.getItems().add(itemAux);
		}
		
		if(itemAux.getStock() > 0) {
			itemAux.setStock( itemAux.getStock()-1);
			c.getCarrito().add(nameItem);
			client.save(c);
			items.save(itemAux);
		}

	
		model.addAttribute("items", aux);		
		model.addAttribute("client",c);
		model.addAttribute("category",cate);
		return "categoryItems";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart(Model model) {
		return "shoppingCart";
	}
	
	@GetMapping("/shoppingCart/{name}")
	public String shoppingCart(Model model, @PathVariable String name) {
		Client c = client.findByName(name);
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	

	@GetMapping("/pay/{name}")
	public String pay(Model model, @PathVariable String name) {
		
		Client c = client.findByName(name);
		if(c.getCarrito().size() > 0) {
			
			for(Item xx : c.getItems()) {
				System.out.println("Name : "+xx.getName());
			}
			
			List aux = new ArrayList<Item>(c.getItems());
			Orders orden1 = new Orders(aux);	
			orders.save(orden1);
			
			c.setCarrito(new ArrayList<String>());
			c.setItems(new ArrayList<Item>());
			
			c.getOrders().add(orden1);
			
			client.save(c);

		}
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	@GetMapping("/delete/{name}/{food}")
	public String delete(Model model, @PathVariable String name, @PathVariable String food) {
		Client c = client.findByName(name);
		
		Iterator<Item> iter = c.getItems().iterator();
		
		while(iter.hasNext()){
			Item auxIt = iter.next();
			if(auxIt.getName().equals(food)) {
				iter.remove();
				c.getCarrito().remove(food);
			}
		}

		// Cambios
		client.save(c);
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	
	
}
