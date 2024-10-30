import { Suspense } from 'react';
import InscriptionPage from '@/components/InscriptionPage/InscriptionPage';
import PinningLoader from '@/components/PinningLoader/PinningLoader';

export default function FormInscriptions({ params }) {
  return (
    <div className="flex size-full flex-1 flex-col">
      <Suspense fallback={<PinningLoader />}>
        <InscriptionPage id={params.id} />
      </Suspense>
    </div>
  );
}
