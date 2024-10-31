import { getCurrentToken } from './auth';

const baseURL = process.env.URL;
const payload = {
  method: 'GET',
  headers: { 'Content-Type': 'application/json' },
  credentials: 'include',
};

export const checkLogin = async tokenFallback => {
  const token = await getCurrentToken();

  return fetch(`${baseURL}/api/auth/check-login`, {
    ...payload,
    headers: { ...payload.headers, Cookie: `token=${token || tokenFallback}` },
  })
    .then(res => {
      return res.status === 200 || res.status === 201;
    })
    .catch(err => false);
};
