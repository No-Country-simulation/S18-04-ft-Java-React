'use server';

import { redirect } from 'next/navigation';
import { signinSchema } from '@/schemas/userSchema';

export async function signin(_state, formData) {
  const signinVerified = signinSchema.safeParse({
    password: formData.get('passwordField'),
    email: formData.get('emailField'),
  });
  if (!signinVerified.success) {
    const errors = Object.fromEntries(
      signinVerified.error.errors
        .filter(({ path }) => path)
        .map(({ path, message }) => [path[0], message])
    );
    return {
      id: crypto.randomUUID(),
      status: 'VALIDATION_ERROR',
      errors,
    };
  }
  const res = await fetch('/api/auth/login', {
    method: 'POST',
    body: JSON.stringify({
      email: signinVerified.data.email,
      password: signinVerified.data.password,
    }),
  });

  if (!res.ok) {
    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: 'Error al inicio de sesión',
    };
  }

  redirect('/');
}
