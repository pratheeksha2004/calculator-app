import React, { useState } from 'react';
import Button from './Button';
import InputField from './InputField';
import Display from './Display';
import axios from 'axios'; // Import axios

const BasicCalculator = () => {
  const [a, setA] = useState('');
  const [b, setB] = useState('');
  const [result, setResult] = useState('');

  const handleOperation = async (operation) => {
    try {
      const baseURL = 'http://localhost:8080';
      const url = `${baseURL}/basic/${operation}`; // Correct URL, parameters below.
      console.log("URL:", url); // Log URL for debugging

      const response = await axios.get(url, {
        params: {  // Pass parameters as 'params' object
          a: a,
          b: b,
        },
      });
      setResult(response.data);


    } catch (err) {
      console.error(err);

      // Handle axios errors
      if (err.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.error("Server responded with error:", err.response.data);

        let errorMessage = 'Invalid input. Please try again.'; // Default message
        if (err.response.data && err.response.data.message) {
          errorMessage = err.response.data.message; // Use backend message
        }

        // Specific Divide by Zero Alert:
        if (errorMessage.toLowerCase().includes("divide by zero")) {
          window.alert("Division by zero is not allowed. Please re-enter your input.");
        } else {
          window.alert(`Invalid input: ${errorMessage}. Please re-enter the input.`); // Generic
        }

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

  const handleInputChange = (setter) => (e) => {
    setter(e.target.value);
  };

  return (
    <div className="p-4">
      <h2 className="text-lg font-bold mb-2">Basic Calculator</h2>
      <InputField
        placeholder="Enter number A"
        value={a}
        onChange={handleInputChange(setA)}
        className="mb-2"
      />
      <InputField
        placeholder="Enter number B"
        value={b}
        onChange={handleInputChange(setB)}
        className="mb-2"
      />

      <div className="grid grid-cols-2 gap-2">
        <Button label="Add" onClick={() => handleOperation('add')} />
        <Button label="Subtract" onClick={() => handleOperation('subtract')} />
        <Button label="Multiply" onClick={() => handleOperation('multiply')} />
        <Button label="Divide" onClick={() => handleOperation('divide')} />
      </div>

      <Display value={result} className="mt-2" />
    </div>
  );
};

export default BasicCalculator;