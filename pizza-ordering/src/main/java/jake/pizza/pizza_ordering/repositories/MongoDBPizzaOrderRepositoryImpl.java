package jake.pizza.pizza_ordering.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.annotation.PostConstruct;
import jake.pizza.pizza_ordering.models.PizzaOrder;

@Repository
public class MongoDBPizzaOrderRepositoryImpl implements PizzaOrderRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;
    private MongoCollection<PizzaOrder> pizzaOrderCollection;

    public MongoDBPizzaOrderRepositoryImpl(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        pizzaOrderCollection = client.getDatabase("test").getCollection("pizzaOrders", PizzaOrder.class);
    }

    @Override
    public List<PizzaOrder> findAll() {
        return pizzaOrderCollection.find().into(new ArrayList<>());
    }

}
