# Getting Started

//The Demo Project has been created using 
 -Spring Boot
 -RESTful Service
 -Swagger for API Document
 -H2DB: In memory
  

#### Running and Testing Project

### How to run the application

./mvnw clean install

./mvnw spring-boot:run

## Run the project in eclipse 
Go to myretail project
go to package com.myretail
Application.java -> right click -> run as java application
You should see no error, now the API server is running


### h2 database console

http://localhost:8080/h2-console

driver class --->  org.h2.Driver

jdbc url --->  jdbc:h2:mem:testdb

username ---> sa

password ---> password

### swager ui

http://localhost:8080/swagger-ui.html

// It has 3 controllers for Testing 

product-controller   
	GET  ---->  To get the product 
	POST ---->  To Post the product data
		
product-name-controller   
	GET  ---->  To get the product name
	
product-name-controller   
	GET  ---->  To get the id, price and value


## 
//15117729, 16483589, 16696652, 16752456, 15643793
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

//Create - POST

{
  "id": 13860428,
  "name": "The Big Lebowski (Blu-ray)(Widescreen)",
  "currentPrice": {
    "id": 13860428,
    "value": 13.49,
    "currencyCode": "USD"
  }
}

{
  "currentPrice": {
    "currencyCode": "EURO",
    "id": 15117729,
    "value": 40.00
  },
  "id": 15117729,
  "name": "Blade Runner"
}