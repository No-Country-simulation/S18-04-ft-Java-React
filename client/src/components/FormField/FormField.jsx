import { cva } from 'class-variance-authority';
import Image from 'next/image';
import { forwardRef } from 'react';
import EyeButton from '../EyeButton/EyeButton';
import { cn } from '@/lib/utils';

const formFieldCVA = cva(
  'autofill-inherit w-full bg-transparent relative z-10 no-outline rounded-md transition-all duration-300 ease text-base  h-12 px-3 py-2 border-gradient  [&:not(:disabled)]:focus:shadow-[0px_2px_22px_rgba(14,252,162,0.25)]',
  {
    variants: {
      error: {
        true: 'error-gradient [&:not(:disabled)]:focus:shadow-[0px_1px_22px_#ff1a1a3b] text-white',
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
const labelCVA = cva('group relative w-full max-w-lg text-base font-normal leading-4 text-white', {
  variants: {
    error: {
      true: 'text-red-500',
      false: '',
    },
    defaultVariants: { error: false },
  },
});
const FormField = forwardRef(function FormField(
  { className = '', id = '', label = '', type = 'text', error, icon, onTypeChange, ...props },
  ref
) {
  const defaultID = id ? id : crypto.randomUUID();

  return (
    <label className={cn(labelCVA({ error: !!error }))} htmlFor={defaultID}>
      {label}

      <div className="relative mt-4">
        {icon ? (
          <Image
            className="absolute left-3 top-1/2 z-10 -translate-y-1/2 text-gray-400"
            width={18}
            height={18}
            src={icon}
            alt={`Icon ${label}`}
          />
        ) : null}
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
    </label>
  );
});

export default FormField;
