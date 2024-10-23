import { SearchBar } from '@/components/SearchBar/SearchBar';
import { getUserProfile } from '@/data/auth';

export async function HomeMain({ token }) {
  const profile = await getUserProfile(token);
  return (
    <main className="flex w-full flex-col px-3">
      <h1 className="mt-8 text-left text-2xl font-semibold text-white">
        !Hola {profile ? profile.name : 'No name'}!
      </h1>
      <h2 className="text-left text-base font-normal text-white">
        ¡Bienvenido a tu próximo desafío profesional! nom
      </h2>
      <SearchBar />
    </main>
  );
}
