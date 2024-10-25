'use server';

import { validateSchema } from '@/lib/validateSchema';
import { inscriptionSchema } from '@/schemas/inscriptionSchema';

export async function sendInscription(_state, formData) {
  const [error, data] = validateSchema(inscriptionSchema, {
    type: formData.get('type'),
    rol: formData.get('rol'),
    timeAvailability: formData.get('timeAvailability'),
    stack: formData.get('stack'),
    isTeamLeader: formData.get('isTeamLeader'),
  });
  console.log({ e: error?.errors });
  if (error) return error;

  return {
    id: crypto.randomUUID(),
    status: 'SUCCESS',
    errors: {},
  };
}
