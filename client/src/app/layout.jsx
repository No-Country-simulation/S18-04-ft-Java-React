import { cn } from '@/lib/utils';
import { dmSans } from '@/styles/font';
import '../styles/globals.css';

export const viewport = {
  width: 'device-width',
  minimumScale: 1,
  initialScale: 1,
  maximumScale: 1,
  userScalable: false,
  viewportFit: 'cover',
  themeColor: [
    { media: '(prefers-color-scheme: light)', color: 'white' },
    { media: '(prefers-color-scheme: dark)', color: 'black' },
  ],
};

export const metadata = {
  title: 'No country',
  applicationName: 'No country',
  description: 'No country app',
  robots: 'index, follow',
  authors: [{ name: 's18-react-java', url: 'https://no-country.up.railway.app' }],
  keywords: ['Nocountry', 'simulacion', 'desarrollo', 'talento', 'it'],
  category: 'webapp',
  icons: [
    {
      rel: 'icon',
      url: '/favicon.ico',
    },
  ],
  openGraph: {
    title: 'No country',
    description: 'No country app',
    url: `https://no-country.up.railway.app`,
    siteName: 'No country',
    type: 'website',
    images: '',
  },
  twitter: {
    card: 'summary_large_image',
    title: 'NNo country',
    description: 'No country app',
  },
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={cn(dmSans.className, dmSans.variable)}>{children}</body>
    </html>
  );
}
