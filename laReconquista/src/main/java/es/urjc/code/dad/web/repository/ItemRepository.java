package es.urjc.code.dad.web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.code.dad.web.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
	List<Item> findAll();
	List<Item> findByNameItem(String name);
}
