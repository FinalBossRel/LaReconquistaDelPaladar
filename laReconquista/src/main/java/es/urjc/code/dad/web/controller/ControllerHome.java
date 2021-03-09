package es.urjc.code.dad.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.urjc.code.dad.web.entity.Category;
import es.urjc.code.dad.web.entity.Client;
import es.urjc.code.dad.web.entity.Item;
import es.urjc.code.dad.web.repository.CategoryRepository;
import es.urjc.code.dad.web.repository.ClientRepository;
import es.urjc.code.dad.web.repository.ItemRepository;

@Controller
public class ControllerHome {
	 
	@Autowired private ClientRepository client;
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
		
		Category cx1 = new Category("Comida Latina",Things); 
		Category cx2 = new Category("Comida Boliviana",Things2); 
		Category cx3 = new Category("Comida Argentina",Things3);
		 

		items.save(item1);
		items.save(item2);
		items.save(item3);
		items.save(item4);
		items.save(item5);
		
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
	
}
