import { Slot } from '@radix-ui/react-slot';
import { cva } from 'class-variance-authority';
import { forwardRef } from 'react';
import { cn } from '@/lib/utils';

const btnCVA = cva(
  `inline-flex items-center justify-center  rounded-lg no-outline truncate disabled:opacity-60 disabled:cursor-default disabled:bg-neutral-500 disable:text-neutral-800 transition-all ease-in-out duration-300`,
  {
    variants: {
      variant: {
        primary:
          'bg-accent-400 text-primary-300 font-semibold [&:not(:disabled)]:hover:shadow-[0px_7px_18px_rgba(12,252,167,0.36)] [&:not(:disabled)]:hover:scale-105 [&:not(:disabled)]:active:scale-100',
        secondary:
          'bg-secondary-200 text-white font-semibold [&:not(:disabled)]:hover:shadow-[0px_7px_18px_rgba(94,23,235,0.36)] [&:not(:disabled)]:hover:scale-105 [&:not(:disabled)]:active:scale-100',
        disabled: 'bg-neutral-500 text-neutral-800 cursor-not-allowed',
        transparent: 'bg-transparent text-white border-transparent',
      },
      size: {
        default: 'h-[44px] py-[10px] px-7',
        full: 'h-[44px] py-[10px] px-7 w-full max-w-[100cqw]',
        fit: 'size-fit py-[10px] px-7',
      },
    },
    defaultVariants: { variant: 'primary', size: 'default' },
  }
);

const Button = forwardRef(function Button(
  { className, variant, size, asChild = false, ...props },
  ref
) {
  const Comp = asChild ? Slot : 'button';
  return <Comp className={cn(btnCVA({ variant, size, className }))} ref={ref} {...props} />;
});

export default Button;
