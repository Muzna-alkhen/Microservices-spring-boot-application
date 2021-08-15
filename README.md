# General Description: 
It is an microservices application similar to the **FitBit API** service which is concerned with health and fitness services using spring-boot framework and spring-cloud.

# Microservices Details : 

1- Gateway Service: Using **Zuul**, it is responsible for directing all the api for the required services.

2- Server Registry service: by **eureka server**, which is responsible for storing network information
   for services defined in the system to be accessed in case of need by other services.

3- Calculate burned calories rate service: a stateless and sync service, its task is to receive (the current weight, weight after loss, and the period during which the weight has been lost) and return the burn rate Calories per week, this service registers itself in the service server as a **eureka client**

4- Calories Calculator service: This is a statefull and sync service ,its receive a list of foods as “names”, it calculates the total calories of the food (according to the database) then it saves the user who requested this service, a **hystrix circuit breaker** installed on this  service since it communicate with body shape service via REST TEMPLATE.
   This service registers itself in the service server as **eureka client**.

5- Body Shape service: It is a statefull and Async service, this service receives an image – as a path - then add it to the database and send it to a message queue for image     processing that there is (Image Processing) microservice that responsible of processing, therefore this service is a producer service – for the message queue- .
 This service registers itself on the services server as a customer **eureka client**.

6- Photo processing service (fake processing) : It is a service that consumes the previous message from the queue. 
   It receives images from the queue and processes each image to determine the shape of the body (not real processing) and then sends the result to the "body shape" service.
   This service registers itself in the service server as a **eureka client**.

7- Hystrix Dashboard service: provide a dashboard to monitor the circuit status since calories calculator service communicate with body shape service, it also shows how the fallback method execute when the circuit is open.

8- Zipkin server service : to trace all the requests starting from gateway service (**Distributed tracing**).

# Implementation Details : 

- spring-boot framework 2.3.11 , spring cloud – Netflix 
