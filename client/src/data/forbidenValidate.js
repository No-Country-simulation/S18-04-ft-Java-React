import { redirect } from 'next/navigation';

export const forbidenValidate = async status => {
  if (status !== 403) return;

  const baseUrl =
    process.env.NODE_ENV === 'production'
      ? 'https://no-country.up.railway.app'
      : 'http://localhost:3000';
  const apiUrl = `${baseUrl}/api/removecookies`;
  const res = await fetch(apiUrl, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' },
  });
  if (!res.ok) return;

  redirect('/welcome');
};
