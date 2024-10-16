'use server';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { signupSchema } from '@/schemas/userSchema';

export async function signup(_state, formData) {
  const signupVerified = signupSchema.safeParse({
    email: formData.get('emailField'),
    password: formData.get('passwordField'),
    validatePassword: formData.get('repeatPasswordField'),
  });

  if (!signupVerified.success) {
    const errors = Object.fromEntries(
      signupVerified.error.errors.map(({ path, message }) => [path[0], message])
    );
    return {
      id: crypto.randomUUID(),
      status: 'VALIDATION_ERROR',
      errors,
    };
  }

  try {
    const payload = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        email: signupVerified.data.email,
        password: signupVerified.data.password,
      }),
    };

    const res = await fetch('https://nocountry.up.railway.app/api/auth/register', payload);

    if (!res.ok || !res.headers.get('Set-Cookie')) {
      const errorResponse = await res.json();
      console.error({ message: `Error al crear la cuenta`, details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: {
          GLOBAL: `Error al crear la cuenta: ${errorResponse.errorMessage}`,
        },
      };
    }

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

    cookies().set('auth_token', token, {
      httpOnly: true,
      secure: true,
      path: '/',
      maxAge: 60 * 60,
    });

    const response = await res.json();

    if (!response.id) {
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

  // redirect(`/signup/confirm/${response.id}`);
  redirect(`/signup/confirm`);
}
