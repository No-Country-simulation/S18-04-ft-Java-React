'use server';

import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';

export async function projectTypeSelect(_state, formData) {
  const data = formData.get('projectTypeId');
  console.log({ data });
  cookies().set('projectType', data, {
    httpOnly: true,
    secure: true,
    path: '/',
    maxAge: 60 * 60 * 24 * 7,
    sameSite: 'lax',
  });
  redirect(`/inscriptions/${data}`);
}
