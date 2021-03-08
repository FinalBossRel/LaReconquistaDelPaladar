package es.urjc.code.dad.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.urjc.code.dad.web.entity.Category;
import es.urjc.code.dad.web.entity.Client;
import es.urjc.code.dad.web.entity.Item;
import es.urjc.code.dad.web.entity.Orders;
import es.urjc.code.dad.web.repository.CategoryRepository;
import es.urjc.code.dad.web.repository.ClientRepository;
import es.urjc.code.dad.web.repository.ItemRepository;
import es.urjc.code.dad.web.repository.OrdersRepository;



@Controller
public class GreetingController {
	
	
	@Autowired private ClientRepository client;
	@Autowired private OrdersRepository orders;
	@Autowired private ItemRepository items;
	@Autowired private CategoryRepository category;
	 
	 

	@PostConstruct
	 public void init(){
		
		Item item1 = new Item("Sopa", 14, 5);
		Item item2 = new Item("Saltenia", 6, 3);
		Item item3 = new Item("Patatas", 7, 5);
		Item item4 = new Item("Carne", 8, 2);
		Item item5 = new Item("Agua", 8, 2);
		
		List<Item> Things = new ArrayList<Item>();

		Things.add(item1);
		Things.add(item2);
		List<Item> Things2 = new ArrayList<Item>();
		Things2.add(item3);
		Things2.add(item4);
		
		List<Item> Things3 = new ArrayList<Item>();
		Things3.add(item5);

		
		Client C1 = new Client("Rel","Flores Angulo",625983775,"jcarlosfa.rel@gmail.com","C/Las Flores","1234");
		Client C2 = new Client("Alberto","Del Pozo",123456789,"usuario@gmail.com","C/Calle Del Mar","1111");
		
		/*
		 * Orders ordersx = new Orders(Things3); Orders orders2 = new Orders(Things2);
		 */
		
		
		Category cx1 = new Category("Comida Latina",Things); 
		Category cx2 = new Category("Comida Boliviana",Things2); 
		Category cx3 = new Category("Comida Argentina",Things3);
		 


		
		items.save(item1);
		items.save(item2);
		items.save(item3);
		items.save(item4);
		items.save(item5);
		/*
		 * orders.save(ordersx); orders.save(orders2);
		 */
		
		
		category.save(cx1); 
		category.save(cx2); 
		category.save(cx3);
		client.save(C1); 
		client.save(C2);
		 

	 	 
	 }
	 
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/home2/{name}")
	public String home2(Model model,  @PathVariable String name){
		Client c = client.findByName(name);
		if(c != null)
			model.addAttribute("client", c);
		model.addAttribute("client",c);
		return "home";
	}
	
	@PostMapping("/newUser")
	public String newUser(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String telephone, @RequestParam String mail, @RequestParam String address, @RequestParam String password) 
	{
		
		Client c = new Client(name, surname,Integer.parseInt(telephone), mail, address, password);
		client.save(c);
		model.addAttribute("id",c.getId());
		model.addAttribute("client", c);
		return "home";
	}
	
	@PostMapping("/singin")
	public String singin(Model model, @RequestParam String name, @RequestParam String password) {
		Client c = client.findByNameAndPassword(name,password);
		if(c !=null) {
			model.addAttribute("id",c.getId());
			model.addAttribute("client", c);
		}
		return "home";
	}
	
	@GetMapping("/datosClient/{name}")
	public String datosClient(Model model, @PathVariable String name) {
		Client c = client.findByName(name);
		if(c != null)
			model.addAttribute("client", c);
		model.addAttribute("client",c);
		return "datosClient";
	}
	
	@GetMapping("/food")
	public String food(Model model){
		List <Item> aux = new ArrayList<Item>(items.findAll());
		List<Category> cate = new ArrayList<Category>(category.findAll());
		model.addAttribute("category",cate);
		model.addAttribute("items", aux);
		
		return "food";
	}
	
	@GetMapping("/food/{name}")
	public String food(Model model,  @PathVariable String name){
		Client c = client.findByName(name);
		List <Item> aux = new ArrayList<Item>(items.findAll());
		List<Category> cate = new ArrayList<Category>(category.findAll());
		
		
		model.addAttribute("category",cate);
		model.addAttribute("client",c);
		
		return "food";
	}
	
	@GetMapping("/category/{nameCategory}")
	public String aniadir(Model model, @PathVariable String nameCategory) {
		
		Category cate = category.findByNameCategory(nameCategory);
		List <Item> aux = new ArrayList<Item>(cate.getItems());		
		
		model.addAttribute("items", aux);		
		return "categoryItems";
	}
	
	@GetMapping("/category/{name}/{nameCategory}")
	public String aniadir(Model model, @PathVariable String name, @PathVariable String nameCategory) {
		
		Client c = client.findByName(name);
		Category cate = category.findByNameCategory(nameCategory);
		List <Item> aux = new ArrayList<Item>(cate.getItems());		
		
		model.addAttribute("category", cate);	
		model.addAttribute("items", aux);		
		model.addAttribute("client",c);
		return "categoryItems";
	}
	
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
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@GetMapping("/contact/{name}")
	public String contact(Model model, @PathVariable String name) {
		Client c = client.findByName(name);
		model.addAttribute("client",c);
		return "contact";
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
