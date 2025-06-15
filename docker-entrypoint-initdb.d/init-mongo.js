db = new Mongo().getDB("test");

db.createCollection('pizzamenu', { capped: false });

db.pizzamenu.insert([
    {"name": "pepperoni", "toppings": ["cheese", "pepperoni", "sauce"]},
    {"name": "cheese", "toppings": ["cheese"] }
]);