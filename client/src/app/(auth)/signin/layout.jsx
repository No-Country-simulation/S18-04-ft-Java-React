export const metadata = {
  title: 'No country - Signin',
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
    url: `https://no-country.up.railway.app/signin`,
    siteName: 'No country',
    type: 'website',
    images: '',
  },
};

export default function SigninLayout({ children }) {
  return (
    <section className="flex size-full flex-col items-center justify-center">
      <h1 className="sr-only">Iniciar sesion</h1>
      {children}
    </section>
  );
}
