#!/bin/sh

# curl --location --request PUT 'localhost:9200/pizza-reviews'

curl --location --request PUT 'localhost:9200/pizza-reviews' \
--header 'Content-Type: application/json' \
--data '{
  "settings": {
    "number_of_shards": 3,
    "number_of_replicas": 1
  },
  "mappings": {
    "properties": {
      "id": {"type": "text"},
      "pizzaName": {"type": "text"},
      "userName": {"type": "text"},
      "reviewDate": {"type": "date", "format":"yyyy-MM-dd'\''T'\''HH:mm:ss.SSS"},
      "stars": { "type": "integer" },
      "comment": {"type": "text",
                    "fields": {
                        "keyword": {
                            "type": "keyword",
                            "ignore_above": 256
                        }
                    }
                }
    }
  }
}'

curl --location 'localhost:9200/pizza-reviews/_doc' \
--header 'Content-Type: application/json' \
--data '{
    "id": "685b0a2a4ac70d1a5dd861d0",
    "pizzaName": "pepperoni",
    "userName": "PizzaLover1",
    "reviewDate": "2025-06-20T22:59:58.636",
    "stars": 5,
    "comment": "This pizza was da bomb"
}'

curl --location 'localhost:9200/pizza-reviews/_doc' \
--header 'Content-Type: application/json' \
--data '{
    "id": "685b0a2a4ac70d1a5dd861d1",
    "pizzaName": "cheese",
    "userName": "PizzaLover2",
    "reviewDate": "2025-06-20T22:59:58.636",
    "stars": 4,
    "comment": "This pizza was great"
}'

curl --location 'localhost:9200/pizza-reviews/_doc' \
--header 'Content-Type: application/json' \
--data '{
    "id": "685b0a2a4ac70d1a5dd861d2",
    "pizzaName": "pepperoni",
    "userName": "PizzaLover3",
    "reviewDate": "2025-06-21T22:59:58.636",
    "stars": 3,
    "comment": "This pizza decent"
}'

curl --location 'localhost:9200/pizza-reviews/_doc' \
--header 'Content-Type: application/json' \
--data '{
    "id": "685b0a2a4ac70d1a5dd861d3",
    "pizzaName": "cheese",
    "userName": "PizzaLover4",
    "reviewDate": "2025-06-22T22:59:58.636Z",
    "stars": 1,
    "comment": "Why on earth would you not just get pepperoni?"
}'