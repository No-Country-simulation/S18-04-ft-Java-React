'use server';

import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { decodePayload } from './decodedToken';
import { profileMapper } from './mapper';
import { userSchema } from '@/schemas/userSchema';
const baseURL = process.env.URL;

export const getCurrentUser = () => {
  const userCookie = cookies().get('USER')?.value;
  let user = null;

  if (userCookie) {
    try {
      user = JSON.parse(userCookie);
      const safeUser = userSchema.safeParse(user);
      if (!safeUser.success) {
        throw new Error('User information is invalid');
      }
    } catch (error) {
      console.error('Error parsing USER cookie:', error.message);
      user = null;
    }
  }

  return user;
};

export const getCurrentToken = () => {
  return cookies().get('token')?.value;
};

export const getUserProfile = async tokenFallback => {
  const token = await getCurrentToken();
  const payload = {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', Cookie: `token=${token || tokenFallback}` },
    credentials: 'include',
  };
  const res = await fetch(`${baseURL}/api/profiles`, payload);
  if (res.status === 404) {
    const user = decodePayload(token || tokenFallback || '');
    redirect(`/signup/confirm/${user?.userId || 'no-user'}`);
  }
  let response;
  try {
    response = await res.json();
  } catch (e) {
    return null;
  }
  return profileMapper(response);
};

export async function deleteCookies() {
  (await cookies()).delete('token');
  (await cookies()).delete('USER');
}
