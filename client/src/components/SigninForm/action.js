'use server';

import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { validateSchema } from '@/lib/validateSchema';
import { signinSchema } from '@/schemas/authSchemas';
const baseURL = process.env.URL;

export async function signin(_state, formData) {
  const [error, data] = validateSchema(signinSchema, {
    password: formData.get('password'),
    email: formData.get('email'),
  });
  if (error) return error;

  let response;

  try {
    const payload = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        email: data.email,
        password: data.password,
      }),
    };

    const res = await fetch(`${baseURL}/api/auth/login`, payload);

    if (!res.ok || !res.headers.get('Set-Cookie')) {
      const errorResponse = await res.json();
      console.error({ message: `Error al iniciar sesión`, details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: {
          GLOBAL: 'Error al iniciar sesión',
        },
      };
    }

    response = await res.json();

    const cookieHeader = res.headers.get('Set-Cookie');
    if (!cookieHeader) {
      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: { GLOBAL: 'El token no se recibió correctamente' },
      };
    }

    const token = cookieHeader
      .split('; ')
      .find(row => row.startsWith('token='))
      .split('=')[1];

    cookies().set('token', token, {
      httpOnly: true,
      secure: true,
      path: '/',
      maxAge: 60 * 60 * 24 * 7,
    });
    cookies().set('USER', JSON.stringify({ id: response.id, email: response.email }), {
      httpOnly: true,
      secure: true,
      path: '/',
      maxAge: 60 * 60,
    });

    if (!response.id) {
      console.error('Error: El ID no se recibió correctamente');

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: 'Error: El ID no se recibió correctamente',
      };
    }
  } catch (error) {
    console.error({
      message: `Se ha producido un error inesperado: ${error.message}`,
      details: { error },
    });

    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: { GLOBAL: 'Se ha producido un error inesperado' },
    };
  }

  redirect(`/home`);
}
