package es.urjc.code.dad.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.code.dad.web.entity.Client;
import es.urjc.code.dad.web.repository.ClientRepository;

@Controller
public class ControllerSingIn {
	
	@Autowired private ClientRepository client;

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
	
}
