'use server';

import { redirect } from 'next/navigation';
import { getCurrentToken, getCurrentUser } from '@/data/auth';
import { decodePayload } from '@/data/decodedToken';
import { validateSchema } from '@/lib/validateSchema';
import { confirmSchema } from '@/schemas/authSchemas';
const baseURL = process.env.URL;

export async function updateProfile(_state, formData) {
  const [error, data] = validateSchema(confirmSchema, {
    name: formData.get('name'),
    lastName: formData.get('lastName'),
    linkedin: formData.get('linkedin'),
    github: formData.get('github'),
  });

  if (error) return error;

  try {
    const token = await getCurrentToken();
    const decoded = decodePayload(token);
    const user = await getCurrentUser();
    const body = {
      profileName: data.name,
      profileLastname: data.lastName,
      linkedinUrl: data.linkedin,
      githubUrl: data.github,
      user: {
        id: user ? user?.id : decoded?.userId || '',
      },
    };

    const payload = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
      credentials: 'include',
      body: JSON.stringify(body),
    };

    const res = await fetch(`${baseURL}/api/profiles`, payload);
    console.log({ res });
    if (!res.ok) {
      const message = await res.json();
      console.log({ message });
      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: { GLOBAL: 'Error al registrar el perfil' },
      };
    }
  } catch (err) {
    console.error({
      message: `Se ha producido un error inesperado: ${err.message}`,
      details: { err },
    });

    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: { GLOBAL: 'Se ha producido un error inesperado' },
    };
  }

  redirect('/home');
}
