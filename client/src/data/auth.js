import { cookies } from 'next/headers';
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

export const getUserProfile = async () => {
  const token = getCurrentToken();

  const payload = {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
    credentials: 'include',
  };
  8;
  const res = await fetch(`${baseURL}/api/profiles`, payload);
  let response;
  try {
    response = await res.json();
  } catch (e) {}
  return profileMapper(response);
};
