import { cva } from 'class-variance-authority';
import { forwardRef } from 'react';
import { cn } from '@/lib/utils';

const textAreaCVA = cva(
  'w-full bg-transparent outline-none rounded-md focus:outline-none active:outline-none border border-secundario-99 transition-all duration-300 ease-in-out text-sm peer placeholder:text-secundario-99 placeholder:opacity-0 focus:placeholder:opacity-100 px-3 py-2 focus:border-secundario-70 [:not(:placeholder-shown)]:border-secundario-70 resize-none p-4',
  {
    variants: {
      error: {
        true: 'border-error-60 focus:border-error-60 placeholder:text-error-60',
        false: '',
      },
    },
    defaultVariants: { error: false },
  }
);

const FormTextAreaField = forwardRef(function FormTextArea(
  { className = '', id = '', label = '', placeholder = '', error, rows = 4, ...props },
  ref
) {
  const defaultID = id || crypto.randomUUID();

  return (
    <div className="group relative w-full max-w-lg text-sm">
      <textarea
        {...props}
        id={defaultID}
        placeholder={placeholder}
        ref={ref}
        rows={rows}
        className={cn(textAreaCVA({ error, className }))}
      />
      <label
        className={cn(
          'bg-neutral-20 text-secundario-99 peer-focus:text-secundario-95 pointer-events-none absolute left-4 top-3 w-fit truncate px-2 py-1 text-base transition-all duration-500 ease-in-out peer-focus:-top-3 peer-focus:left-3 peer-focus:translate-y-0 peer-focus:scale-[.85] peer-[:not(:placeholder-shown)]:-top-3 peer-[:not(:placeholder-shown)]:left-3 peer-[:not(:placeholder-shown)]:translate-y-0 peer-[:not(:placeholder-shown)]:scale-[.85]',
          error
            ? 'text-error-60 peer-focus:text-error-60 peer-[:not(:placeholder-shown)]:text-error-60'
            : ''
        )}
        htmlFor={defaultID}>
        {label}
      </label>
      {error && <span className="text-error-60 absolute -bottom-5 left-0 text-xs">{error}</span>}
    </div>
  );
});

export default FormTextAreaField;
