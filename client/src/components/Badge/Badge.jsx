import { cva } from 'class-variance-authority';
import * as React from 'react';

import { cn } from '@/lib/utils';

const badgeVariants = cva(
  'inline-flex items-center rounded-full border px-2.5 py-0.5 text-xs font-semibold transition-colors focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2',
  {
    variants: {
      variant: {
        default: 'border-transparent bg-primary-50 text-primary-foreground ',
        secondary: 'border-transparent bg-label text-black ',
        destructive: 'border-transparent bg-accent-400 text-black ',
        outline: 'text-foreground',
        cohort: 'bg-secondary-100 text-white border-transparent',
        hackathon: 'bg-secondary-500 text-white border-transparent',
      },
    },
    defaultVariants: {
      variant: 'default',
    },
  }
);

function Badge({ className, variant, ...props }) {
  return <div className={cn(badgeVariants({ variant }), className)} {...props} />;
}

export { Badge, badgeVariants };
