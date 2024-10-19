import { SearchBar } from '@/components/SearchBar/SearchBar';

export const HomeMain = ({ name }) => {
  return (
    <main className="flex w-full flex-col px-3">
      <h1 className="mt-8 text-left text-2xl font-semibold text-white">!Hola {name}!</h1>
      <h2 className="text-left text-base font-normal text-white">
        ¡Bienvenido a tu próximo desafío profesional!
      </h2>
      <SearchBar />
    </main>
  );
};
