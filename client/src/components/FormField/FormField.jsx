import { cva } from 'class-variance-authority';
import Image from 'next/image';
import { forwardRef } from 'react';
import EyeButton from '../EyeButton/EyeButton';
import { cn } from '@/lib/utils';

//Ejemplo de estilo de un form field
const formFieldCVA = cva(
  'w-full bg-transparent relative z-10 no-outline rounded-md transition-all duration-300 ease-in-out text-sm  h-12 px-3 py-2 border-none',
  {
    variants: {
      error: {
        true: 'border-red-400 focus:border-red-400',
        false: '',
      },
      icon: {
        true: 'pl-10',
        false: '',
      },
      password: {
        true: 'pr-10',
        false: '',
      },
      defaultVariants: { error: false, icon: false, password: false },
    },
  }
);
const labelCVA = cva('text-base font-normal leading-4 text-white', {
  variants: {
    error: {
      true: 'text-red-500',
      false: '',
    },
    defaultVariants: { error: false },
  },
});
// Icons: EyeOff, Github, Linkedin, Unlock, User, Whatsapp (Actualmente)
const FormField = forwardRef(function FormField(
  { className = '', id = '', label = '', type = 'text', error, icon, onTypeChange, ...props },
  ref
) {
  const defaultID = id ? id : crypto.randomUUID();

  return (
    <div className="group relative w-full max-w-lg text-sm">
      <label className={cn(labelCVA({ error: !!error }))} htmlFor={defaultID}>
        {label}
      </label>
      <div className="relative mt-4">
        {icon ? (
          <Image
            className="absolute left-3 top-1/2 z-10 -translate-y-1/2 text-gray-400"
            width={18}
            height={18}
            src={`/images/${icon}.svg`}
            alt="Icon field"
          />
        ) : null}
        <div className="from-accent-400 to-primary-50 absolute inset-0 rounded-md bg-gradient-to-r"></div>
        <div className="bg-gradient-field absolute inset-px rounded-md"></div>
        <input
          {...props}
          id={defaultID}
          ref={ref}
          type={type}
          className={cn(
            formFieldCVA({ error: !!error, className, icon: !!icon, password: !!onTypeChange })
          )}
        />
        {onTypeChange ? <EyeButton onTypeChange={onTypeChange} /> : null}
      </div>
      {error ? (
        <span className="absolute -bottom-5 left-0 text-xs text-red-400">{error}</span>
      ) : null}
    </div>
  );
});

export default FormField;
