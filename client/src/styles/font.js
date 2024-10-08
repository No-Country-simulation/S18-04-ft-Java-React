import { Open_Sans } from 'next/font/google';

// Next descargara la fuenta de google y la optimizara automaticamente por ti
export const openSans = Open_Sans({
  subsets: ['latin'],
  variable: '--font-open-sans',
  style: ['normal'],
  weight: ['400', '500', '600', '700'],
});
