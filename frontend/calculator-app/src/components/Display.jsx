import React from 'react';

const Display = ({ value, className }) => {
  return (
    <div className={`bg-gray-100 border rounded p-2 text-right ${className}`}>
      {value}
    </div>
  );
};

export default Display;