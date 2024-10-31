import { getCurrentToken } from './auth';

const baseURL = process.env.URL;

export const getInscriptionForm = async id => {
  const token = await getCurrentToken();
  const response = await fetch(`${baseURL}/api/event-records/register-form/${id}`, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
    credentials: 'include',
  });

  if (!response.ok) {
    return [];
  }
  const data = await response.json();
  return data;
};
