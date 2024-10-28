import { cookies } from 'next/headers';
import { getCurrentToken } from './auth';
const baseURL = process.env.URL;

export const getProjectType = async () => {
  const token = cookies().get('token')?.value;
  const response = await fetch(`${baseURL}/api/project-types`, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
    credentials: 'include',
  });
  // Como podria manejar el caso de que el token este expirado (?)
  // Si response response.status 403
  if (!response.ok) {
    return {
      status: response.status,
      data: [],
    };
  }
  const data = await response.json();

  return {
    status: response.status,
    data,
  };
};
