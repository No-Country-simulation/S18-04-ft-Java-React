'use server';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { confirmSchema } from '@/schemas/userSchema';

export async function updateProfile(_state, formData) {
  const profileVerified = confirmSchema.safeParse({
    name: formData.get('name'),
    lastName: formData.get('lastName'),
    linkedin: formData.get('linkedin'),
    github: formData.get('github'),
  });

  if (!profileVerified.success) {
    const errors = Object.fromEntries(
      profileVerified.error.errors.map(({ path, message }) => [path[0], message])
    );

    return {
      id: crypto.randomUUID(),
      status: 'VALIDATION_ERROR',
      errors,
    };
  }

  let response;

  try {
    const token = cookies().get('token')?.value;

    if (!token) {
      return {
        status: 'AUTH_ERROR',
        errors: { GLOBAL: 'Token no encontrado' },
      };
    }

    const payload = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json', Authorization: `Bearer ${token}` },

      body: JSON.stringify({
        name: profileVerified.data.name,
        lastName: profileVerified.data.lastName,
        linkedin: profileVerified.data.linkedin,
        github: profileVerified.data.github,
      }),
    };

    const res = await fetch('https://nocountry.up.railway.app/api/profiles', payload);

    if (!res.ok) {
      const errorResponse = await res.json();
      console.error({ message: 'Error al actualizar el perfil', details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: { GLOBAL: 'Error al actualizar el perfil' },
      };
    }

    response = await res.json();
    console.log('Perfil actualizado:', response);
  } catch (err) {
    console.error({
      message: `Se ha producido un error inesperado: ${error.message}`,
      details: { err },
    });

    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: { GLOBAL: 'Se ha producido un error inesperado' },
    };
  }
}

redirect('/');
