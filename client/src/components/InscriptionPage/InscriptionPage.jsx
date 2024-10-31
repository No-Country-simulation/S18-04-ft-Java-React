import { InscriptionForm } from '../InscriptionForm/InscriptionForm';
import { getInscriptionForm } from '@/data/getInscriptionForm';

export default async function InscriptionPage({ id }) {
  const formItems = await getInscriptionForm(id);
  return <InscriptionForm formItems={formItems} />;
}
