# CurrencyCalculation-microservice
This project is developed using the Spring Boot framework to build a Java microservices

 
## Features ##

1. REST APIs for Calculation microservice for currency calculation

/currency-calculation/from/{from}/to/{to}/amount/{amount}

CalculationResponse{
to	string
from	string
rate	number($double)
amount	number($double)
convertedAmount	number($double)
message	string
}
 
2. REST APIs for Exchange microservice to return exchange rates

## Technologies Used
Java 17

Spring Boot 3.1.4

Spring Data JPA 

MySQL for the database

Swagger for API documentation

Maven for dependency management

Git for version control


## Running the Application. 

First, create data in MySQL database for the testing (using SQL scripts provided)  
Once the application is running, you can perform the following:

Access the API:
Visit below URL to access the application endpoints.

http://localhost:8080/currency-calculation/from/SGD/to/AUD/amount/100
http://localhost:8000/currency-rate/from/SGD/to/AUD



    
