import React from 'react';

const Button = ({ label, onClick, className }) => {
  return (
    <button className={`bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ${className}`} onClick={onClick}>
      {label}
    </button>
  );
};

export default Button;