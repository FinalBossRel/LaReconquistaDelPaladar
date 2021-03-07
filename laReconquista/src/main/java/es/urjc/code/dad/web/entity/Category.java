package es.urjc.code.dad.web.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nameCategory;
	
	@OneToMany
	private List <Item> items;
	
	public Category(){}
	public Category(String nameCategory, List<Item> items) {
		super();
		this.nameCategory = nameCategory;
		this.items = items;
	}

	public String getName() {
		return nameCategory;
	}

	public void setName(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
