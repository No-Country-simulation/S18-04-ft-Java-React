import { getCurrentToken } from './auth';

const baseUrl = process.env.URL;

export async function fetchUserData() {
  const token = await getCurrentToken();

  const url = `${baseUrl}/api/teams/byUser`;

  const payload = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      Cookie: `token=${token}`,
    },
    credentials: 'include',
  };

  const response = await fetch(url, payload);

  if (!response.ok) {
    return [];
  }

  const data = await response.json();

  return data;
}
