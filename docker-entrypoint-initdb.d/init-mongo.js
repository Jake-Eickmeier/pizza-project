// Create mongo database
db = new Mongo().getDB("test");


// Collections and data for pizza menu service
db.createCollection('pizzaMenu', { capped: false });
db.createCollection('pizzaSpecials', { capped: false });

db.pizzaMenu.insertMany([
    {"_id": ObjectId("68715674e36ec57a5dba8a7d"), "name": "pepperoni", "toppings": ["cheese", "pepperoni", "sauce"], "priceInCents": 1399, "tags": ["MEATLOVER"]},
    {"_id": ObjectId("68715674e36ec57a5dba8a7e"), "name": "cheese", "toppings": ["cheese"], "priceInCents": 1299, "tags": ["VEGETARIAN"]}
]);

db.pizzaSpecials.insertMany([
    {"pizzaId": ObjectId("68715674e36ec57a5dba8a7d"), "newPriceInCents": 999, "specialDay": "THURSDAY", "expirationDate": null },
    {"pizzaId": ObjectId("68715674e36ec57a5dba8a7e"), "newPriceInCents": 899, "specialDay": "FRIDAY", "expirationDate": null }
]);

// Collection and data for pizza ordering service
db.createCollection('pizzaOrders', { capped: false });
db.pizzaOrders.insertMany([
    {"itemsPurchased": {"pepperoni": 1, "cheese": 2}, "userEmailAddress": "pizzaLover1@gmail.com", "purchaseDate": new Date(), "priceInCents": 2699},
    {"itemsPurchased": {"pepperoni": 3, "cheese": 1}, "userEmailAddress": "pizzaEnjoyer7@gmail.com", "purchaseDate": new Date(), "priceInCents": 3799}
]);
