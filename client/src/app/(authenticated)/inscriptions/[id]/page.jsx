import { InscriptionForm } from '@/components/InscriptionForm/InscriptionForm';
import { getInscriptionForm } from '@/data/getInscriptionForm';

export default async function FormInscriptions({ params }) {
  const formItems = await getInscriptionForm(params.id);
  return (
    <div className="flex size-full flex-1 flex-col">
      <InscriptionForm formItems={formItems} />
    </div>
  );
}
