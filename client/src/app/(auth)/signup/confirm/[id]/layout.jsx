export async function generateMetadata({ params }) {
  const { id } = params;
  return {
    title: 'No country - Complete profile',
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
      url: `https://no-country.up.railway.app/confirm/${id}`,
      siteName: 'No country',
      type: 'website',
      images: '',
    },
  };
}

export default function ConfirmLayout({ children }) {
  return (
    <div className="mt-20 w-full">
      <h1 className="sr-only">Completa los datos de tu perfil</h1>
      {children}
    </div>
  );
}
