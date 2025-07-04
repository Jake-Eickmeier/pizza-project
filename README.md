# pizza-project
A locally hostable pizza shop web app where I can practice and demonstrate various technologies in a microservice architecture.

### Disclaimer: 
Please understand that this project is not finished if you're reading this! This project is meant to be something that I can contribute to piecewise over time, with individually working microservices and functionalities that will eventually end up tying each other together. I will leave a checklist detailing things that I may plan on introducing or refactoring in the future.

Also understand that in some circumstances, I may opt to use a piece of technology that is slightly less viable than another purely for the purpose of demonstrating more coverage of a wider range of technologies. I will try to leave some remarks in these cases, but don't be too alarmed if you see a relational database squeezed in where non-relational would be better and so-on :smiley: .

## Architecture
Here is the most recent snapshot of what the entire architecture will look like, made in Miro. Most major interactions will be dictated, but some will be omitted to maintain clarity and readability.Note that revisions may be made as I make further development progress.
![Pizza Architecture](resources/PizzaArchitecture.PNG)


## How to run
Start by running `docker-compose up -d` in the root directory of this project. Each microservice within will have its dependencies arranged within that docker-compose. Running the docker-compose command in this directory will start all dependencies for all microservices.
Then, run whichever microservices you desire using the instructions in said service or your IDE. Generically, it will likely be runnable using `mvn spring-boot:run` in the given service directory. Later on when more services are available there will be a script to take care of running all at once, or some sort of containerization. Service will be available on port 8080, 8081, 8082 and so-on, and the mongodb can be accessed using the uri in the service's application.properties file if desired.

