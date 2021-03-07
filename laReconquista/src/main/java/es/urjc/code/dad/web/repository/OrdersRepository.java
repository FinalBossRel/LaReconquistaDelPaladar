package es.urjc.code.dad.web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.code.dad.web.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long>{
	//List<Order> findByNameOrder(int number);
}
