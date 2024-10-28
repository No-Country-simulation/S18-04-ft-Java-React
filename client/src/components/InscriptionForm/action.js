'use server';

import { validateSchema } from '@/lib/validateSchema';
import { inscriptionSchema } from '@/schemas/inscriptionSchema';

export async function sendInscription(request, formData) {
  console.log({ request });
  const [error, data] = validateSchema(inscriptionSchema, {
    type: formData.get('type'),
    rol: formData.get('rol'),
    timeAvailability: formData.get('timeAvailability'),
    stack: formData.get('stack'),
    isTeamLeader: formData.get('isTeamLeader'),
  });
  console.log({ e: error?.errors });
  if (error) return error;

  const body = {
    schedule: data.timeAvailability,
    tl: data.isTeamLeader === 'true',
    roleType: { roleTypeId: data.rol },
    stack: [{ frameworkId: data.stack }],
    language: [{ languageId: data.language }],
    event: { eventId: 'no-tengo-id' },
  };
  return {
    id: crypto.randomUUID(),
    status: 'SUCCESS',
    errors: {},
  };
}
