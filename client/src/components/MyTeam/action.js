'use server';

import { getCurrentToken } from '@/data/auth';
const baseURL = process.env.URL;

export async function getTeam({ id }) {
  console.log(id);

  let response;

  try {
    const token = getCurrentToken();
    const payload = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json', Cookie: `token=${token}` },
      credentials: 'include',
      body: JSON.stringify({
        teamId: id,
      }),
    };
    const res = await fetch(`${baseURL}/api/participants/find_all_by_team_id`, payload);

    console.log(res);

    if (!res.ok) {
      const errorResponse = await res.json();
      console.error({ message: `Error al obtener datos de equipo`, details: { errorResponse } });

      return {
        id: crypto.randomUUID(),
        status: 'FETCH_ERROR',
        errors: {
          GLOBAL: 'Error al obtener datos de equipo',
        },
      };
    }

    response = await res.json();
    console.log(response);
  } catch (error) {
    console.error({
      message: `Se ha producido un error inesperado: ${error.message}`,
      details: { error },
    });

    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: { GLOBAL: 'Se ha producido un error inesperado' },
    };
  }
}
