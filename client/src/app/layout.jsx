import { cn } from '@/lib/utils';
import { dmSans } from '@/styles/font';
import '../styles/globals.css';
import 'normalize.css';

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={cn(dmSans.className, dmSans.variable)}>{children}</body>
    </html>
  );
}
