import Image from 'next/image';
import React from 'react';
import style from '@/styles/input.module.css';

function Input({
  id,
  type = 'text',
  name,
  label,
  iconLeft,
  iconRight,
  onIconRightClick,
  value,
  onChange,
  autoComplete,
}) {
  return (
    <div className={style.inputContentLabel}>
      <label className={style.inputLabel} htmlFor={id}>
        {label}
        <div className={style.inputWrapper}>
          {iconLeft && (
            <span className={style.iconSpan}>
              <Image src={iconLeft} alt={`icono ${name}`} width={18} height={18} />
            </span>
          )}
          <input
            className={style.input}
            id={id}
            type={type}
            name={name}
            onChange={onChange}
            value={value}
            autoComplete={autoComplete}
            minLength="3"
          />
          {iconRight && (
            <span className={style.iconSpanRight} onClick={onIconRightClick}>
              <Image src={iconRight} alt={`icono ${name}`} width={18} height={18} />
            </span>
          )}
        </div>
      </label>
    </div>
  );
}

export default Input;
