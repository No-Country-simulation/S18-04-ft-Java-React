import Image from 'next/image';
import Link from 'next/link';
import { Suspense } from 'react';
import PinningLoader from '../PinningLoader/PinningLoader';
import SimulationsContent from '../SimulationsContent/SimulationsContent';

async function SimulationsPage() {
  return (
    <div className="container relative top-20 mx-auto p-4">
      <div className="flex flex-col md:flex-row">
        <Link href="/home" className="mb-4 inline-block md:mb-0" aria-label="Volver al perfil">
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
    </div>
  );
}

export default SimulationsPage;
