package jake.pizza.pizza_ordering.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jake.pizza.pizza_ordering.dtos.PizzaOrderDTO;
import jake.pizza.pizza_ordering.repositories.PizzaOrderRepository;

@Service
public class PizzaOrderingServiceImpl implements PizzaOrderingService {

    private final PizzaOrderRepository pizzaOrderRepository;

    public PizzaOrderingServiceImpl(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    @Override
    public List<PizzaOrderDTO> findAll() {
        return pizzaOrderRepository.findAll()
                .stream()
                .map(PizzaOrderDTO::new)
                .toList();
    }
}
