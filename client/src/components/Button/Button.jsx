import { Slot } from '@radix-ui/react-slot';
import { cva } from 'class-variance-authority';
import { forwardRef } from 'react';
import { cn } from '@/lib/utils';

//Ejemplo de como usar CVA(Class variant authority) para estilizar un boton
// Hay que actualizar estos estilos y variante segun lo que necesitemos
const btnCVA = cva(
  'inline-flex items-center justify-center outline-none rounded-xl focus:outline-none active:outline-none focus-visible:outline-none no-underline truncate disabled:opacity-60 disabled:cursor-default disabled:bg-neutral-90 disable:text-neutral-10 transition-all ease-in-out duration-300',
  {
    variants: {
      variant: {
        default:
          'bg-primario-70 text-primario-10 [&:not(:disabled)]:hover:bg-primario-80 [&:not(:disabled)]:hover:shadow-[0px_1px_2px_0px_rgba(0,0,0,0.3)] [&:not(:disabled)]:active:bg-primario-70',
        outline:
          'bg-transparent text-primario-60 border border-primario-70 [&:not(:disabled)]:hover:bg-neutral-40 [&:not(:disabled)]:hover:shadow-[0px_1px_2px_0px_rgba(0,0,0,0.3)] [&:not(:disabled)]:active:bg-transparent',
        elevated: `bg-primario-70 shadow-[0px_2px_2px_0px_rgba(0,0,0,0.3)] text-primario-10
          [&:not(:disabled)]:hover:shadow-[0px_2px_2px_0px_rgba(0,0,0,0.6)] [&:not(:disabled)]:active:bg-primario-70,`,
        disabled: 'bg-[rgba(229,229,225,1)] cursor-not-allowed',
        transparent: 'bg-transparent text-white border-transparent',
      },
      size: {
        default: 'h-[42px] px-6',
        sm: 'h-[42px] px-6',
        lg: 'h-[42px] px-6',
        full: 'h-[42px] px-6 w-full max-w-[100cqw]',
        fit: 'size-fit p-1',
      },
    },
    defaultVariants: { variant: 'default', size: 'default' },
  }
);

const Button = forwardRef(function Button(
  { className, variant, size, asChild = false, ...props },
  ref
) {
  //Si asChild es true en lugar de usar un elemento "button", utiliza un "Slot" de radix
  // Esto es util cuando queres usar el estilo del boton, pero no queres que el elemento sea un boton
  const Comp = asChild ? Slot : 'button';
  return <Comp className={cn(btnCVA({ variant, size, className }))} ref={ref} {...props} />;
});

export default Button;
