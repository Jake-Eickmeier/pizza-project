// package jake.pizza.pizza_reviews;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.json.JsonMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// @Configuration
// public class JacksonObjectMapperConfiguration {
    
//     @Bean
//     public ObjectMapper jacksonObjectMapper() {
//         ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
//         // mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//         // JavaTimeModule javaTimeModule = new JavaTimeModule();
//         // mapper.registerModule(javaTimeModule);
//         // mapper.configure()
//         return mapper;
//     }
// }
