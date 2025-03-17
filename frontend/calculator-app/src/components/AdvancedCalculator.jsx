import React, { useState } from 'react';
import Button from './Button';
import InputField from './InputField';
import Display from './Display';
import axios from 'axios';

const AdvancedCalculator = () => {
  const [a, setA] = useState('');
  const [b, setB] = useState(''); // For power
  const [result, setResult] = useState('');

  const handleOperation = async (operation) => {
    try {
      const baseURL = 'http://localhost:8080';
      let url = `${baseURL}/advanced/${operation}`; // Base URL

      let params = {};
      if (operation === 'power') {
        params = { base: a, exponent: b };
      } else {
        params = { a: a };
      }

      console.log("URL:", url);
      console.log("Params:", params);

      const response = await axios.get(url, { params: params });
      setResult(response.data);

    } catch (err) {
      console.error(err);

      if (err.response) {
        // The request was made and the server responded with a status code
        console.error("Server responded with error:", err.response.data);
        let errorMessage = 'Invalid input. Please try again.';
        if (err.response.data && err.response.data.message) {
          errorMessage = err.response.data.message;
        }
        window.alert(`Invalid input: ${errorMessage}. Please check and re-enter the input.`);

      } else if (err.request) {
        // The request was made but no response was received
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
      <h2 className="text-lg font-bold mb-2">Advanced Calculator</h2>
      <InputField placeholder="Enter number A" value={a} onChange={(e) => setA(e.target.value)} className="mb-2" />
      {/* Show input B only for power operation */}
      <InputField
        placeholder="Enter number B (for power)"
        value={b}
        onChange={(e) => setB(e.target.value)}
        className="mb-2"
        style={{ display: 'block' }}
      />


      <div className="grid grid-cols-2 gap-2">
        <Button label="Sqrt" onClick={() => handleOperation('sqrt')} />
        <Button label="Power" onClick={() => handleOperation('power')} />
        <Button label="Log" onClick={() => handleOperation('log')} />
        <Button label="Sin" onClick={() => handleOperation('sin')} />
      </div>

      <Display value={result} className="mt-2" />
    </div>
  );
};

export default AdvancedCalculator;