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

  const payload = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      email: signupVerified.data.email,
      password: signupVerified.data.password,
    }),
  };

  try {
    const res = await fetch('https://nocountry.up.railway.app/api/auth/register', payload);

    if (!res.ok || !res.headers.get('Set-Cookie')) {
      const errorResponse = await res.json();
      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: errorResponse.message || 'Error al crear la cuenta',
      };
    }

    const cookieHeader = res.headers.get('Set-Cookie');

    console.log(cookieHeader);

    if (!cookieHeader) {
      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: 'Error: El token no se recibió correctamente',
      };
    }

    cookies().set('auth_token', cookieHeader, {
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

    redirect(`/signup/confirm/${response.id}`);
  } catch (error) {
    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: 'Error al conectar con el servidor',
    };
  }
}
