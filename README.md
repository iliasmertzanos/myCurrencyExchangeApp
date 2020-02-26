# myCurrencyExchangeApp
## An app using microservices architecture based on Spring Boot


The project is based on following technologies:

* Java 1.8 (or higher)
* Spring Boot
* Database H2 (In-Memory)
* Maven
* RabbitMQ (connecting microservices with zipkin)
* Zuul API Gateway 
* Eureka Naming Server (making distributed calls)
* Ribbon (client side load balancing)
* Feign REST Client
* Sleuth and Zipkin (Distributed tracing with Spring Cloud)

## Features

The project is a simple microservice based application with two main services that communicate with each other to calculate currency conversions.
So the currency conversion service communicates with the currency exchange service, in order to get the current exchange ratio and then converts a given ammount of money into the given currency.

I recommend that you start the services in the following order:
- Eureka Naming Server
- Zuul API Gateway Server
- Currency conversion and Currency exchange Service

According to the current configuration afterwards you can call the services over the following URLs:


|     Application       |     URL          |
| ------------- | ------------- |
|  Currency Converter Service - Direct Call| http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10|
|  Currency Converter Service - Feign| http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000|
| Currency Exchange Service | http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR|
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/refresh |

## Extra Installations

Please keep in mind that the following servers and tools have to be installed and configured manually:

- RabbitMQ (see https://www.rabbitmq.com/download.html)
- Zipkin 
    -Quick Start Page
      https://zipkin.io/pages/quickstart
    -Downloading Zipkin Jar
      https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec
      Command to run
      RABBIT_URI=amqp://localhost java -jar zipkin-server-2.5.2-exec.jar
