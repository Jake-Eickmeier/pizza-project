// Create mongo database
db = new Mongo().getDB("test");


// Collection and data for pizza menu service
db.createCollection('pizzaMenu', { capped: false });

db.pizzaMenu.insert([
    {"name": "pepperoni", "toppings": ["cheese", "pepperoni", "sauce"]},
    {"name": "cheese", "toppings": ["cheese"] }
]);

// Collection and data for pizza ordering service
db.createCollection('pizzaOrders', { capped: false });
db.pizzaOrders.insert([
    {"itemsPurchased": {"pepperoni": 1, "cheese": 2}, "userEmailAddress": "pizzaLover1@gmail.com", "purchaseDate": new Date(), "priceInCents": 2699},
    {"itemsPurchased": {"pepperoni": 3, "cheese": 1}, "userEmailAddress": "pizzaEnjoyer7@gmail.com", "purchaseDate": new Date(), "priceInCents": 3799}
]);
