import React, { useState } from 'react';
import BasicCalculator from './components/BasicCalculator';
import AdvancedCalculator from './components/AdvancedCalculator';
import ExpressionCalculator from './components/ExpressionCalculator';

function App() {
  const [selectedCalculator, setSelectedCalculator] = useState(null);

  const handleCalculatorSelect = (calculatorType) => {
    setSelectedCalculator(calculatorType);
  };

  return (
    <div className="container mx-auto p-4 bg-gray-100 rounded-lg shadow-xl min-h-screen flex flex-col justify-center items-center">
      <h1 className="text-3xl font-bold mb-8 text-center text-gray-800">Calculator App</h1>

      {selectedCalculator === null ? (
        // Initial Button Choices
        <div className="flex flex-col items-center space-y-4">
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-3 px-6 rounded-xl shadow-md transition duration-300 ease-in-out transform hover:scale-105"
            onClick={() => handleCalculatorSelect('basic')}
          >
            Basic Calculator
          </button>
          <button
            className="bg-green-500 hover:bg-green-700 text-white font-bold py-3 px-6 rounded-xl shadow-md transition duration-300 ease-in-out transform hover:scale-105"
            onClick={() => handleCalculatorSelect('advanced')}
          >
            Advanced Calculator
          </button>
          <button
            className="bg-purple-500 hover:bg-purple-700 text-white font-bold py-3 px-6 rounded-xl shadow-md transition duration-300 ease-in-out transform hover:scale-105"
            onClick={() => handleCalculatorSelect('expression')}
          >
            Expression Calculator
          </button>
        </div>
      ) : (
        // Show the selected calculator
        <div className="flex flex-col items-center">
          {selectedCalculator === 'basic' && <BasicCalculator />}
          {selectedCalculator === 'advanced' && <AdvancedCalculator />}
          {selectedCalculator === 'expression' && <ExpressionCalculator />}
          <button
            className="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded shadow-md mt-8 transition duration-300 ease-in-out transform hover:scale-105"
            onClick={() => setSelectedCalculator(null)}
          >
            Back to Calculator Selection
          </button>
        </div>
      )}
    </div>
  );
}

export default App;