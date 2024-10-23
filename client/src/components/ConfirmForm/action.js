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
    const token = getCurrentToken();
    const decoded = decodePayload(token);
    const user = getCurrentUser();
    const body = {
      profileName: data.name,
      profileLastname: data.lastName,
      linkedinUrl: data.linkedin,
      githubUrl: data.github,
      user: {
        id: user ? user?.id : decoded?.id || ""
      },
    };
    const payload = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
      credentials: 'include',
      body: JSON.stringify(body),
    };

    const res = await fetch(`${baseURL}/api/profiles`, payload);

    if (!res.ok) {
      const errorResponse = await res.json();
      console.error({ message: 'Error al actualizar el perfil', details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: { GLOBAL: 'Error al actualizar el perfil' },
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
