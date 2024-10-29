import { getCurrentToken } from './auth';
import { forbidenValidate } from './forbidenValidate';

const baseURL = process.env.URL;

export const getInscriptionForm = async id => {
  const token = getCurrentToken();
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
