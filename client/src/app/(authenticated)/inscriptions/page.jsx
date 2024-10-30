import { Suspense } from 'react';
import PinningLoader from '@/components/PinningLoader/PinningLoader';
import ProjectTypeSelectionPage from '@/components/ProjectTypeSelectionPage/ProjectTypeSelectionPage';

export default function FormInscriptions() {
  return (
    <div className="flex size-full flex-1 flex-col">
      <Suspense fallback={<PinningLoader />}>
        <ProjectTypeSelectionPage />
      </Suspense>
    </div>
  );
}
