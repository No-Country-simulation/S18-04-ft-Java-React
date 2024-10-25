import Link from 'next/link';

export const Meeting = () => {
  return (
    <div className="border-gradient mx-10 mb-56 items-center justify-center border p-4 text-center leading-9">
      <h3 className="font-bold">Próxima reunión con el Team Leader</h3>
      <p>Fecha: 14 de noviembre, 18:30hs</p>
      <p>
        Link a la reunión:
        <Link href="" className="ml-2 text-primary-50 underline">
          Unirse a la reunión
        </Link>
      </p>
    </div>
  );
};
