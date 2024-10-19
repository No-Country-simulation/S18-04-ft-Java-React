export const metadata = {
  title: 'No country - Signup',
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
    url: `https://no-country.up.railway.app/signup`,
    siteName: 'No country',
    type: 'website',
    images: '',
  },
};

export default function SignupLayout({ children }) {
  return (
    <section className="mt-20 w-full">
      <h1 className="sr-only">Registrate</h1>
      {children}
    </section>
  );
}
