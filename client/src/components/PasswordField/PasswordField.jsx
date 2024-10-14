'use client';

import Link from 'next/link';
import { forwardRef, useState } from 'react';
import FormField from '../FormField/FormField';

const PasswordFormField = forwardRef(function FormFieldFacade(
  { type = 'password', activeForgot = false, ...props },
  ref
) {
  const [inputType, setInputType] = useState(type);

  const handleTypeChange = updatedType => {
    setInputType(updatedType);
  };

  return (
    <div className="group relative flex w-full items-center justify-center">
      <FormField {...props} ref={ref} type={inputType} onTypeChange={handleTypeChange} />
      {activeForgot ? (
        <Link
          href="#"
          className="absolute -bottom-7 left-1/2 -translate-x-1/2 text-nowrap text-center text-sm transition-colors duration-300 hover:text-accent-200">
          ¿Olvidaste tu contraseña?
        </Link>
      ) : null}
    </div>
  );
});

export default PasswordFormField;
