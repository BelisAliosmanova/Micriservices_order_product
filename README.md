## Homework from java intership
Assignment: Design and implement a microservices-based system using Feign</br>
client as a communication mechanism between services. The system should</br>
consist of two services: a "Product Service" and an "Order Service." The Product</br>
Service is responsible for managing products, while the Order Service handles</br>
order processing.</br>
### But I will try with Eureka Server :)
Tasks:</br>
1. Set up a new Spring Boot project for each service (Product Service and</br>
Order Service).</br>
2. Create a RESTful API for the Product Service that includes endpoints for</br>
creating, retrieving, updating, and deleting products.</br>
3. Implement the necessary functionality in the Product Service to handle</br>
the API endpoints.</br>
4. Use Feign client in the Order Service to consume the Product Service API.</br>
Define Feign client interfaces in the Order Service for accessing the</br>
Product Service endpoints.</br>
5. Create RESTful API endpoints in the Order Service for placing new orders.</br>
These endpoints should interact with the Product Service through the</br>
Feign client.</br>
6. Implement the necessary functionality in the Order Service to handle the</br>
API endpoints for order placement, including making requests to the</br>
Product Service.</br>
7. Test the system by starting both services and using a tool like Postman or</br>
cURL to interact with the API endpoints.</br>
