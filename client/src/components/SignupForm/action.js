'use server';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { validateSchema } from '@/lib/validateSchema';
import { signupSchema } from '@/schemas/authSchemas';
const baseURL = process.env.URL;

export async function signup(_state, formData) {
  const [error, data] = validateSchema(signupSchema, {
    email: formData.get('email'),
    password: formData.get('password'),
    repeatPassword: formData.get('repeatPassword') || null,
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

    const res = await fetch(`${baseURL}/api/auth/register`, payload);

    if (!res.ok || !res.headers.get('Set-Cookie')) {
      const errorResponse = await res.json();
      console.error({ message: `Error al crear la cuenta`, details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: {
          GLOBAL: 'Error al crear la cuenta',
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
      maxAge: 60 * 60,
    });
<<<<<<< HEAD
   /* cookies().set('USER', JSON.stringify({ id: response.id, email: response.email }), {
      httpOnly: true,
      secure: true,
      path: '/',
      maxAge: 60 * 60,
    });
*/
=======
    cookies().set(
      'USER',
      JSON.stringify({ id: response.id, email: response.email, isFirstSignin: true }),
      {
        httpOnly: true,
        secure: true,
        path: '/',
        maxAge: 60 * 60,
      }
    );

>>>>>>> d9077d97c6a4b4da1554bf47bdddffbccafba5da
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

  redirect(`/signup/confirm/${response.id}`);
}
