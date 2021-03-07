package es.urjc.code.dad.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.code.dad.web.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	Category findByNameCategory(String name);
	List<Category> findAll();

}
