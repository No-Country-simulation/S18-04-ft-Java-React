'use client';

import { forwardRef, useState } from 'react';
import FormField from '../FormField/FormField';

const PasswordFormField = forwardRef(function FormFieldFacade(
  { type = 'password', ...props },
  ref
) {
  const [inputType, setInputType] = useState(type);

  const handleTypeChange = updatedType => {
    setInputType(updatedType);
  };

  return <FormField {...props} ref={ref} type={inputType} onTypeChange={handleTypeChange} />;
});

export default PasswordFormField;
