Calculator project

## Description
A simple backend calculator application built with Java, Spring Boot, and Maven. It supports basic operations like addition, subtraction, multiplication, and division, and persists calculations in a Database. It also provides an endpoint to fetch previously made calculations.

## Technologies Used
Java 17

Spring Boot 2.7.5

Maven

H2 Database (in-memory)

## Installation Instructions
1- Clone the repository: https://github.com/ShannieCh/AwesomeTele2-calculator.git

2- Install dependencies: mvn install

3- Running the Application: mvn spring-boot:run

The application will start at http://localhost:8080

## API Endpoints
Add: GET http://localhost:8080/api/calculator/add?num1=5&num2=3

Subtract: GET http://localhost:8080/api/calculator/subtract?num1=5&num2=3

Multiply: GET http://localhost:8080/api/calculator/multiply?num1=5&num2=3

Divide: GET http://localhost:8080/api/calculator/divide?num1=5&num2=3

Fetching previously made calculations: GET http://localhost:8080/api/calculator/allPreviousCalculations

## Testing
This project includes JUnit test cases. Run mvn test to execute the tests.

