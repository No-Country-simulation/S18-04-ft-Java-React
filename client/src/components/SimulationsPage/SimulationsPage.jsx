import Image from 'next/image';
import Link from 'next/link';
import { Suspense } from 'react';
import PinningLoader from '../PinningLoader/PinningLoader';
import SimulationsContent from '../SimulationsContent/SimulationsContent';

async function SimulationsPage() {
  return (
    <div className="container mx-auto p-4">
      <Link href="/home" className="absolute left-5 top-20 p-2" aria-label="Volver al perfil">
        <Image
          src="/images/arrowLeft.png"
          className="gradient-custom stroke-[3]"
          width={20}
          height={20}
          alt="Flecha izquierda"
        />
      </Link>
      <Suspense fallback={<PinningLoader />}>
        <SimulationsContent />
      </Suspense>
    </div>
  );
}

export default SimulationsPage;
