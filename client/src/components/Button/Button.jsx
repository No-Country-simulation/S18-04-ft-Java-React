import React from 'react';
import style from '@/styles/button.module.css';

const Button = ({ type, name, extraClass }) => {
  return (
    <button className={[style.button, extraClass].join(' ')} type={type}>
      {name}
    </button>
  );
};

export default Button;
