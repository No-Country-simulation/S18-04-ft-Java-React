'use server';

import { cookies } from 'next/headers';
import { validateSchema } from '@/lib/validateSchema';
import { inscriptionSchema } from '@/schemas/inscriptionSchema';

const baseURL = process.env.URL;

export async function sendInscription(request, formData) {
  const [error, data] = validateSchema(inscriptionSchema, {
    type: formData.get('type'),
    rol: formData.get('rol'),
    timeAvailability: formData.get('timeAvailability'),
    stack: formData.get('stack'),
    isTeamLeader: formData.get('isTeamLeader'),
  });
  if (error) return error;
  const projetId = await cookies().get('projectType')?.value;
  const body = {
    schedule: data.timeAvailability,
    tl: data.isTeamLeader === 'true',
    roleType: { roleTypeId: data.rol },
    stack: [{ frameworkId: data.stack }],
    language: [{ languageId: data.language }],
    event: { eventId: projetId },
  };
  console.log({ body });
  /*const ff = await fetch(`${baseURL}/api/event-records`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    credentials: 'include',
    body: JSON.stringify(body),
  });*/
  return {
    id: crypto.randomUUID(),
    status: 'SUCCESS',
    errors: {},
  };
}
