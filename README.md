# Meter Your Calories Platform
## Order Service

This service contains the logic for creating an order for an employee and saving the information in the database and also showing the entire history of orders carried out by an employee.

When presenting the entire history of orders, the total value of calories is displayed in the sum of all orders.
For the integrations with this service needs to make a HTTP request for the Product Controller.
Product Controller has all the REST Interface to comunicate with Product Service.

This service consists of the following structure:

1. models
2. mappers
3. Repositories
4. Services
5. Web (Controllers)

The **models** have the data models for both database access and the Data Transfer Object (DTOs) used in the REST interface

**Mappers** are static classes, whose objective is to map data allowing code reuse.

The **Repositories** are where the Data Access Objects (DAO) are to make queries to the database.
Hibernate and JPA were used to access the database

**Services** is where all the platform's business logic can be found

In the **Web package** it is possible to find the **Controller** that exposes a REST interface that allows the creation of orders as well as the measurement of calories ingested per order and the sum of the number of calories of all orders


## Examples of the API

### Create a food order [POST /order]

Create a order of a items available on the cafetaria.

Example Request:

<table>
    <tr>
        <th>Method</th>
        <td>POST</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8082/order</a> </td>
    </tr>
</table>

Body:
````json
{
  "username": "Luis Piteira", 
  "foodDtoList": [
    {
      "name": "Sour Lemonade",
      "food_group": "BEVERAGE",
      "calories": 12
    },
    {
      "name": "Cesar Salad",
      "food_group": "MAIN_COURSE",
      "calories": 450
    }
  ]
}
````

Example Response:
````json
200 Ok
````

### Get All orders & Stats by User [POST /order/stats/{name}]

Get all the history of orders and represents the sum of calories from all orders, and the sum of calories from each order

Example Request:

<table>
    <tr>
        <th>Method</th>
        <td>POST</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8082/order/stats/Luis Piteira</a> </td>
    </tr>
    <tr>
        <th>Content-type</th>
        <td> application/json </td>
    </tr>
</table>

body:
````json
{
  "total_calories": 924,
  "orders": [
    {
      "username": "Luis Piteira",
      "order_ts": "2023-02-19T12:43:09",
      "order_total_calories": 462,
      "foodDtoList": [
        {
          "name": "Sour Lemonade",
          "food_group": "BEVERAGE",
          "calories": 12
        },
        {
          "name": "Cesar Salad",
          "food_group": "MAIN_COURSE",
          "calories": 450
        }
      ]
    },
    {
      "username": "Luis Piteira",
      "order_ts": "2023-02-19T17:32:51",
      "order_total_calories": 462,
      "foodDtoList": [
        {
          "name": "Sour Lemonade",
          "food_group": "BEVERAGE",
          "calories": 12
        },
        {
          "name": "Cesar Salad",
          "food_group": "MAIN_COURSE",
          "calories": 450
        }
      ]
    }
  ]
}
````


Example Response:

````json
200 Ok
````
