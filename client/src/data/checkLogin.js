import { getCurrentToken } from './auth';

const baseURL = process.env.URL;
const payload = {
  method: 'GET',
  headers: { 'Content-Type': 'application/json' },
  credentials: 'include',
};

export const checkLogin = tokenFallback => {
  const token = getCurrentToken() || tokenFallback;

  return fetch(`${baseURL}/api/auth/check-login`, {
    ...payload,
    headers: { ...payload.headers, Cookie: `token=${token}` },
  })
    .then(res => {
      return res.status === 200 || res.status === 201;
    })
    .catch(err => false);
};
