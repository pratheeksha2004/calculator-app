import React, { useState } from 'react';
import Button from './Button';
import InputField from './InputField';
import Display from './Display';
import axios from 'axios';

const ExpressionCalculator = () => {
  const [expression, setExpression] = useState('');
  const [result, setResult] = useState('');

  const handleEvaluate = async () => {
    try {
      const baseURL = 'http://localhost:8080'; // Replace with your actual API endpoint
      const url = `${baseURL}/calculate`;

      const response = await axios.post(url, { expression });
      console.log("URL:" + url);

      setResult(response.data);

    } catch (err) {
      console.error(err);

      if (err.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.error("Server responded with error:", err.response.data);
        let errorMessage = "Invalid expression. Please re-enter a valid expression."; // Default message
        if (err.response.data && err.response.data.message) {
          errorMessage = err.response.data.message; // Use message from backend
        }

        window.alert(`Error: ${errorMessage}`);

      } else if (err.request) {
        // The request was made but no response was received
        // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
        // http.ClientRequest in node.js
        console.error("No response received:", err.request);
        window.alert("No response from server. Please check your connection and try again.");
      } else {
        // Something happened in setting up the request that triggered an Error
        console.error("Error setting up the request:", err.message);
        window.alert("Network error or invalid response. Please check your connection and try again.");
      }

      setResult('');
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-lg font-bold mb-2">Expression Calculator</h2>
      <InputField
        placeholder="Enter expression (e.g., 2 + (3 * 4))"
        value={expression}
        onChange={(e) => setExpression(e.target.value)}
        className="mb-2"
      />
      <Button label="Evaluate" onClick={handleEvaluate} />
      <Display value={result} className="mt-2" />
    </div>
  );
};

export default ExpressionCalculator;