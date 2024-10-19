export const metadata = {
  title: 'No country - Home',
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
    url: `https://no-country.up.railway.app/home`,
    siteName: 'No country',
    type: 'website',
    images: '',
  },
};

export default function HomeLayout({ children }) {
  return (
    <div className="no-bg-gradient mx-auto mb-5 flex size-full max-w-3xl flex-1 flex-col">
      {children}
    </div>
  );
}
