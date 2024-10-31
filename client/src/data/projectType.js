import { cookies } from 'next/headers';

const COOKIE_ID = 'projectType';

export const saveProjectType = data => {
  cookies().set(COOKIE_ID, data, {
    httpOnly: true,
    secure: true,
    path: '/',
    maxAge: 60 * 60 * 24 * 7,
    sameSite: 'lax',
  });
};

export const removeProjectType = () => {
  cookies().delete(COOKIE_ID);
};
