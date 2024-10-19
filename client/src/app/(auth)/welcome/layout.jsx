export const metadata = {
  title: 'No country - Welcome',
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
    url: `https://no-country.up.railway.app/welcome`,
    siteName: 'No country',
    type: 'website',
    images: '',
  },
};

export default function WelcomeLayout({ children }) {
  return (
    <section>
      <h1 className="sr-only">Bienvenido a la app de No country</h1>
      <h2 className="sr-only">Puedes iniciar sesion o registrarte</h2>
      {children}
    </section>
  );
}
