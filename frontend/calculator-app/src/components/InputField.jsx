import React from 'react';

const InputField = ({ value, onChange, placeholder, className }) => {
  return (
    <input
      type="text"
      className={`shadow appearance-none border rounded py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline ${className}`}
      value={value}
      onChange={onChange}
      placeholder={placeholder}
    />
  );
};

export default InputField;