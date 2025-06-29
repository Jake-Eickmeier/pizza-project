package jake.pizza.pizza_reviews.services;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.search.Hit;

import jake.pizza.pizza_reviews.dtos.PizzaReviewDTO;
import jake.pizza.pizza_reviews.models.PizzaReview;

@Service
public interface PizzaReviewService {

    List<PizzaReviewDTO> findAll();

    void savePizzaReview(PizzaReviewDTO pizzaOrder);

    // TODO: Could allow pagination sizing here instead of hardcoding in implementation if desired
    List<PizzaReviewDTO> findReviewsByPizzaName(String pizzaName);

    List<Hit<PizzaReviewDTO>> searchReviewsByKeyword(String keyword) throws ElasticsearchException, IOException;

    // TODO: Endpoint to get all reviews by keyword search/pizza tag filter

}
