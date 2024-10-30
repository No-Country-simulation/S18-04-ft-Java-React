import { Card, CardContent } from '../Card/Card';
import SimulationInfo from '../SimulationsInfo/SimulationInfo';
import { fetchUserData } from '@/data/getTeamByUser';

export default async function SimulationsContent() {
  const data = await fetchUserData();

  if (!data) {
    return (
      <div className="flex min-h-screen items-center justify-center bg-inherit">
        <div className="rounded-lg p-8 text-center">
          <h2 className="mb-4 text-2xl font-bold text-red-600">Error</h2>
          <p className="text-l text-white">
            No se pudieron cargar las simulaciones. Por favor, intenta de nuevo más tarde.
          </p>
        </div>
      </div>
    );
  }

  const activeSimulation = data.find(p => p.state === 'Progress');
  const previousSimulations = data.filter(p => p.state !== 'Progress');

  return (
    <div className="mt-16 flex flex-col items-center space-y-8">
      <section className="w-full max-w-2xl">
        <h2 className="mb-4 text-xl font-bold">Simulación Actual</h2>
        {activeSimulation ? (
          <Card className="w-full border-transparent bg-current-simulation">
            <CardContent className="p-4">
              <SimulationInfo simulation={{ ...activeSimulation }} />
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
                <CardContent className="p-6">
                  <SimulationInfo simulation={simulation} />
                </CardContent>
              </Card>
            ))}
          </div>
        )}
      </section>
    </div>
  );
}
