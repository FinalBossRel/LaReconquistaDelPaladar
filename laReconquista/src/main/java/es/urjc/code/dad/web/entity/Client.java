package es.urjc.code.dad.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String surname;
	private int telephone;
	private String mail;
	private String address;
	private String password;
	
	private ArrayList <String> carrito;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Item> items;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Orders> orders;
	
	public Client() {}
	
	public Client(String name, String surname, int telephone, String mail, String address, String password
			) {
		super();
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.mail = mail;
		this.address = address;
		this.password = password;
		this.orders = new ArrayList<Orders>();
		this.carrito = new ArrayList<String>();
		this.items = new ArrayList<Item>();
	}
	


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

	public ArrayList <String> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList <String> carrito) {
		this.carrito = carrito;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
