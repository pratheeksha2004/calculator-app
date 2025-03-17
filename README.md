# Calculator Application (Frontend + Backend)

This repository contains a calculator application with both a Spring Boot backend and a React-based frontend. It features basic arithmetic operations, advanced functions (sqrt, sin, log, power), and an expression evaluator with BODMAS operator precedence. Separate REST API endpoints are available for each calculator mode.

## Features

*   **Basic Calculator:** Supports addition, subtraction, multiplication, and division.
*   **Advanced Calculator:** Includes functions for square root, sine, logarithm, and power.
*   **Expression Calculator:** Evaluates mathematical expressions with operator precedence (BODMAS/PEMDAS).
*   **REST API:** Provides separate endpoints for each calculator type.
*   **Spring Boot Backend:** Built using Spring Boot for easy setup and deployment.
*   **React Frontend:** User-friendly interface built with React.
*   **Dependency Injection (Backend):** Uses Spring's dependency injection for modularity and testability.

## Technologies Used

*   **Backend:**
    *   Java
    *   Spring Boot
    *   Maven
    *   Git
*   **Frontend:**
    *   React - JavaScript library for building user interfaces
    *   Axios - Promise-based HTTP client for making API requests
    *   JavaScript
    *   HTML
    *   CSS

## Project Structure
calculator-app/
├── backend/ # Spring Boot Backend Code
│ ├── src/main/java/ # Java source code
│ ├── pom.xml # Maven project configuration
│ ├── ... # Other backend files
├── frontend/ # React Frontend Code
│ ├── public/ # Static assets (HTML, CSS, images)
│ ├── src/ # React components and logic
│ ├── package.json # Frontend dependencies
│ ├── ... # Other frontend files
├── README.md # This file
├── .gitignore # Specifies intentionally untracked files that Git should ignore


## Setup/Installation

### Backend

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

### Frontend

1.  **Navigate to the frontend directory:**
    ```bash
    cd frontend
    ```
2.  **Install dependencies:**
    ```bash
    npm install  # or yarn install
    ```
3.  **Configure API endpoint:**

    *   In `frontend/src/App.js` (or wherever your API calls are), make sure the API endpoint is correctly configured to point to your backend server (e.g., `http://localhost:8080/calculate`). You might need to adjust this based on how you deploy your backend.

4.  **Start the frontend development server:**
    ```bash
    npm start  # or yarn start
    ```
    The frontend application should now be running in your browser, typically on `http://localhost:3000`.

## Usage

1.  **Start the Backend:** Follow the Backend setup instructions.

2.  **Start the Frontend:** Follow the Frontend setup instructions.

3.  **Access the calculator app in your browser:** Open your web browser and navigate to the frontend URL (e.g., `http://localhost:3000`).

4.  **Perform calculations:** Use the calculator interface to enter numbers and operators. The application will send requests to the backend API to perform the calculations and display the results.

## API Endpoints (Backend)

*   **Basic Calculator:** `GET /calculate/basic?expression={expression}`
    *   Example: `GET /calculate/basic?expression=2+3`
    *   Response:
        ```json
        {
          "result": 5.0
        }
        ```
*   **Advanced Calculator:** `GET /calculate/advanced?expression={expression}`
    *   Example: `GET /calculate/advanced?expression=sqrt(25)`
    *   Response:
        ```json
        {
          "result": 5.0
        }
        ```
*   **Expression Calculator:** `GET /calculate/expression?expression={expression}`
    *   Example: `GET /calculate/expression?expression=(2+3)*4`
    *   Response:
        ```json
        {
          "result": 20.0
        }
        ```

    **Note:** These endpoints expect the expression to be passed as a query parameter named "expression".

## Axios in the Frontend

The frontend uses [Axios](https://axios-http.com/) to make HTTP requests to the backend API. Axios is a promise-based HTTP client that simplifies the process of making requests and handling responses.

*   **Why Axios?**
    *   **Automatic JSON transformation:** Axios automatically serializes request data to JSON and parses JSON responses.
    *   **Error handling:**  Easier error handling compared to the built-in `fetch` API.
    *   **Interceptors:**  Allows you to intercept requests and responses for tasks like adding authentication headers or logging.

*   **Example (Making a request with Axios):**

    ```javascript
    import axios from 'axios';

    const apiUrl = 'http://localhost:8080/calculate/basic'; // Replace with your actual API endpoint

    axios.get(apiUrl, {
        params: {
            expression: '2 + 2'
        }
    })
      .then(response => {
        console.log('Result:', response.data.result);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
    ```

## Error Handling

The API returns appropriate HTTP error codes (e.g., 400 Bad Request, 500 Internal Server Error) and JSON error messages in case of invalid input or other errors. The frontend displays user-friendly error messages based on the API responses.
