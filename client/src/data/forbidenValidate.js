import { revalidatePath } from 'next/cache';
const baseUrl =
  process.env.NODE_ENV === 'production'
    ? 'https://no-country.up.railway.app'
    : 'http://localhost:3000';

export const forbidenValidate = async status => {
  if (status !== 403) return;

  await fetch(`${baseUrl}/api/removecookies`, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' },
  });
};
