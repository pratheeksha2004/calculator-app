# Calculator Application

This repository contains a calculator application built with Spring Boot. It features basic arithmetic operations, advanced functions (sqrt, sin, log, power), and an expression evaluator with BODMAS operator precedence. Separate REST API endpoints are available for each calculator mode.

## Features

*   **Basic Calculator:** Supports addition, subtraction, multiplication, and division.
*   **Advanced Calculator:** Includes functions for square root, sine, logarithm, and power.
*   **Expression Calculator:** Evaluates mathematical expressions with operator precedence (BODMAS/PEMDAS).
*   **REST API:** Provides separate endpoints for each calculator type.
*   **Spring Boot:** Built using Spring Boot for easy setup and deployment.
*   **Dependency Injection:** Uses Spring's dependency injection for modularity and testability.

## Technologies Used

*   Java
*   Spring Boot
*   Maven
*   Git

## Setup/Installation

1.  **Prerequisites:**
    *   Java Development Kit (JDK) 17 or higher
    *   Maven
2.  **Clone the repository:**
    ```bash
    git clone https://github.com/pratheeksha2004/calculator-app.git
    ```
3.  **Navigate to the project directory:**
    ```bash
    cd calculator-app
    ```
4.  **Build the application:**
    ```bash
    mvn clean install
    ```
5.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## Usage

The application provides the following REST API endpoints:

*   **Basic Calculator:** `GET /calculate/basic`
    *   Request Body:
        ```json
        {
          "expression": "2 + 3"
        }
        ```
    *   Response:
        ```json
        {
          "result": 5.0
        }
        ```
*   **Advanced Calculator:** `GET /calculate/advanced`
    *   Request Body:
        ```json
        {
          "expression": "sqrt(25)"
        }
        ```
    *   Response:
        ```json
        {
          "result": 5.0
        }
        ```
*   **Expression Calculator:** `GET /calculate/expression`
    *   Request Body:
        ```json
        {
          "expression": "(2 + 3) * 4"
        }
        ```
    *   Response:
        ```json
        {
          "result": 20.0
        }
        ```

## Error Handling

The API returns appropriate HTTP error codes (e.g., 400 Bad Request, 500 Internal Server Error) and JSON error messages in case of invalid input or other errors.
