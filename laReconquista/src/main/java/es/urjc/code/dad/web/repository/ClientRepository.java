package es.urjc.code.dad.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.dad.web.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	
	Client findByNameAndPassword(String name, String password);
	Client findByName(String Name);
	List<Client> findAll();

}
