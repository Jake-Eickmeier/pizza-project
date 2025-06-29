package jake.pizza.pizza_reviews.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import jake.pizza.pizza_reviews.dtos.PizzaReviewDTO;
import jake.pizza.pizza_reviews.models.PizzaReview;
import jake.pizza.pizza_reviews.repositories.PizzaRatingRepository;
import jake.pizza.pizza_reviews.repositories.PizzaReviewRepository;

@Service
public class PizzaReviewServiceImpl implements PizzaReviewService {

    private final PizzaRatingRepository pizzaRatingRepository;

    private final PizzaReviewRepository pizzaReviewRepository;

    private final ElasticsearchClient elasticsearchClient;

    public PizzaReviewServiceImpl(PizzaRatingRepository pizzaRatingRepository, PizzaReviewRepository pizzaReviewRepository, ElasticsearchClient elasticsearchClient) {
        this.pizzaRatingRepository = pizzaRatingRepository;
        this.pizzaReviewRepository = pizzaReviewRepository;
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public List<PizzaReviewDTO> findAll() {
        return pizzaRatingRepository.findAll()
                .stream()
                .map(PizzaReviewDTO::new)
                .toList();
    }

    @Override
    public void savePizzaReview(PizzaReviewDTO pizzaReviewDTO) {
        pizzaReviewRepository.save(pizzaReviewDTO.toPizzaReview());
        // TODO: Also extract the pizza RATING (just stars) and save to the pizza ratings mongodb
    }

    @Override
    public List<PizzaReviewDTO> findReviewsByPizzaName(String pizzaName) {
        return pizzaReviewRepository.findByPizzaName(pizzaName, PageRequest.of(0, 10))
            .stream()
            .map(pr -> new PizzaReviewDTO(pr))
            .collect(Collectors.toList());
    }

    @Override
    // TODO: Return back to this https://www.baeldung.com/spring-data-elasticsearch-tutorial#bd-querying
    // Looks like that method has been deprecated
    public List<Hit<PizzaReviewDTO>> searchReviewsByKeyword(String keyword) throws ElasticsearchException, IOException {
        SearchResponse<PizzaReviewDTO> response = elasticsearchClient.search(s -> s
            .index("pizza-reviews")
            .query(q -> q
                .match(t -> t
                    .field("comment")
                    .query(keyword)
                )
            ),
            PizzaReviewDTO.class
        );
        // List<PizzaReviewDTO> hitList = response.hits()
        // .hits()
        // .stream()
        // .map(pizzaReviewHit -> new PizzaReviewDTO(pizzaReviewHit))
        // .collect(Collectors.toList());
        return response.hits().hits();
    }



}
