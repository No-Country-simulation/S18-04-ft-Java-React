'use server';

import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { validateSchema } from '@/lib/validateSchema';
import { inscriptionSchema } from '@/schemas/inscriptionSchema';

const baseURL = process.env.URL;

export async function sendInscription(_state, formData) {
  const [error, data] = validateSchema(inscriptionSchema, {
    rol: formData.get('rol'),
    timeAvailability: formData.get('timeAvailability'),
    language: formData.get('language'),
    frameworks: formData.get('frameworks'),
    isTeamLeader: formData.get('isTeamLeader'),
  });
  if (error) return error;
  const body = {
    schedule: data.timeAvailability,
    tl: data.isTeamLeader,
    roleType: { roleTypeId: data.rol },
    stack: [{ frameworkId: data.stack }],
    language: { languageId: data.language }, 
    event: { eventId: '00-0000-0000' },
  };
  console.log({ body });
  const res = await fetch(`${baseURL}/api/event-records`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    credentials: 'include',
    body: JSON.stringify(body),
  });
  console.log({ res });
  if (!res.ok) {
    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: { GLOBAL: 'Error al asignar los equipos.' },
    };
  }

  redirect('/home');
}
