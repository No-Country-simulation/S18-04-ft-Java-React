import React from 'react';
import style from '@/styles/divider.module.css';

export const Divider = () => {
  return (
    <div className={style.dividerContainer}>
      <div className={style.divider}></div>
      <span className={style.dividerText}>O</span>
      <div className={style.divider}></div>
    </div>
  );
};
