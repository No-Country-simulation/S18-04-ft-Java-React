import Image from 'next/image';
import Link from 'next/link';
import { Card, CardContent } from '../Card/Card';
import { Badge } from '@/components/Badge/Badge';

const baseUrl = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8090';

function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
}

async function fetchUserData() {
  try {
    const token = getCookie('token');

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
    console.log(response, 'holaaaa');

    if (response.status === 404) {
      throw new Error('Recurso no encontrado. Verifica la URL del endpoint.');
    }

    if (!response.ok) {
      throw new Error(`Error en la solicitud: ${response.status} ${response.statusText}`);
    }

    const data = await response.json();

    if (!data || !Array.isArray(data.participants)) {
      throw new Error('La respuesta del servidor no tiene el formato esperado');
    }

    return data;
  } catch (err) {
    console.error('Error al obtener los datos del usuario:', err);
    return null;
  }
}

async function SimulationsPage() {
  const data = await fetchUserData();
  console.log({ data });

  if (!data) {
    return <div className="container mx-auto p-4">Error</div>;
  }

  const activeSimulation = data.participants.find(p => p.state === 'Progress');
  const previousSimulations = data.participants.filter(p => p.state !== 'Progress');

  return (
    <div className="container mx-auto p-4">
      <Link href="/home" className="absolute left-5 top-20 p-2" aria-label="Volver al perfil">
        <Image
          src="/images/arrowLeft.png"
          className="gradient-custom stroke-[3]"
          width={20}
          height={20}
          alt="Flecha izquierda"
        />
      </Link>

      <div className="mt-16 flex flex-col items-center space-y-8">
        <section className="w-full max-w-2xl">
          <h2 className="mb-4 text-xl font-bold">Simulación Actual</h2>
          {activeSimulation ? (
            <Card className="w-full border-transparent bg-current-simulation">
              <CardContent className="p-4">
                <SimulationInfo simulation={{ ...activeSimulation, teamName: data.teamName }} />
              </CardContent>
            </Card>
          ) : (
            <p>No hay simulación activa actualmente.</p>
          )}
        </section>

        <section className="w-full max-w-2xl">
          <h2 className="mb-4 text-xl font-bold">Simulaciones Anteriores</h2>
          {previousSimulations.length === 0 ? (
            <p>No hay simulaciones anteriores.</p>
          ) : (
            <div className="space-y-4">
              {previousSimulations.map((simulation, index) => (
                <Card key={index} className="w-full border-transparent bg-primary-500">
                  <CardContent className="p-4">
                    <SimulationInfo simulation={{ ...simulation, teamName: data.teamName }} />
                  </CardContent>
                </Card>
              ))}
            </div>
          )}
        </section>
      </div>
    </div>
  );
}

function SimulationInfo({ simulation }) {
  return (
    <div className="space-y-2">
      <h3 className="flex items-center font-semibold">
        <Image
          src="/images/briefcaseWhite.png"
          className="mr-3"
          width={20}
          height={20}
          alt="Briefcase icon"
        />
        {simulation.teamName}
      </h3>

      <p>Evento: {simulation.eventName}</p>
      <p>Fecha de inicio: {simulation.eventDateStart}</p>
      <p>Fecha de Finalización: {simulation.eventDateEnd}</p>
      <Badge variant={simulation.state === 'Progress' ? 'default' : 'secondary'}>
        {simulation.state === 'Progress' ? 'En curso' : 'Finalizado'}
      </Badge>
      <Badge
        className="ml-4"
        variant={
          simulation.eventDescription === 'Seleccionado'
            ? 'destructive'
            : simulation.eventDescription === 'Cohorte'
              ? 'cohort'
              : 'hackathon'
        }>
        {simulation.eventDescription}
      </Badge>
    </div>
  );
}

export default SimulationsPage;
