import { getCurrentToken } from './auth';
const baseURL = process.env.URL;

export const getProjectType = async () => {
  const token = getCurrentToken();
  const response = await fetch(`${baseURL}/api/project-types`, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
    credentials: 'include',
  });

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
