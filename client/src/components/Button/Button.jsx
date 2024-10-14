import React from 'react';
import style from '@/styles/button.module.css';

const Button = ({ type, name, extraClass, onClick }) => {
  return (
    <button className={[style.button, extraClass].join(' ')} type={type} onClick={onClick}>
      {name}
    </button>
  );
};

export default Button;
