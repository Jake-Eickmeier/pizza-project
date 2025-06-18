package jake.pizza.pizza_ordering.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import jake.pizza.pizza_ordering.models.PizzaOrder;

@Repository
public interface PizzaOrderRepository {

    public List<PizzaOrder> findAll();
}