package jake.pizza.pizza_reviews.dtos;

import java.util.Date;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.DateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import jake.pizza.pizza_reviews.models.PizzaReview;

public record PizzaReviewDTO(
        String id,
        String pizzaName,
        String userName,
        @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
        // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        LocalDateTime reviewDate,
        int stars,
        String comment) {

    public PizzaReviewDTO(PizzaReview pizzaReview) {
        this(pizzaReview.getId(), pizzaReview.getPizzaName(), pizzaReview.getUserName(),
                pizzaReview.getReviewDate(), pizzaReview.getStars(), pizzaReview.getComment());
    }

    public PizzaReview toPizzaReview() {
        ObjectId objectId = id == null ? new ObjectId() : new ObjectId(id);
        return new PizzaReview(objectId.toHexString(), pizzaName, userName, reviewDate, stars, comment);
    }

}
