import React from 'react';
import style from '@/styles/form.module.css';

function Form({ children, onSubmit }) {
  return (
    <form className={style.form} onSubmit={onSubmit}>
      <fieldset className={style.formFieldSet}>
        <div className={style.formContent}>{children}</div>
      </fieldset>
    </form>
  );
}

export default Form;
