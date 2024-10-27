'use client';
import Image from 'next/image';
import Link from 'next/link';
import React from 'react';
import { Card, CardContent } from '../Card/Card';
import { Badge } from '@/components/Badge/Badge';

function SimulationsPage() {
  const currentSimulation = {
    title: 'Simulación 1',
    startDate: '2023-10-26',
    endDate: '2023-11-26',
    status: 'En curso',
    event: 'Hackathon',
  };

  const previousSimulation = [
    {
      title: 'Simulación 2',
      startDate: '2023-09-01',
      endDate: '2023-10-26',
      status: 'finalizado',
      event: 'Cohorte',
    },
    {
      title: 'Simulación 3',
      startDate: '2023-08-01',
      endDate: '2023-09-26',
      status: 'finalizado',
      event: 'Seleccionado',
    },
  ];
  return (
    <div className="container mx-auto p-4">
      <Link href="/home" className="absolute left-5 top-20 p-2" arial-label="Volver al perfil">
        <Image
          src="/images/arrowLeft.png"
          className="gradient-custom stroke-[3]"
          width={20}
          height={20}
        />
      </Link>

      <div className="mt-16 flex flex-col items-center space-y-8">
        <section className="w-full max-w-2xl">
          <h2 className="mb-4 text-xl font-bold">Simulación Actual</h2>

          {currentSimulation.length === 0 ? (
            <p>No hay simulaciones actuales</p>
          ) : (
            <Card className="w-full border-transparent bg-current-simulation">
              <CardContent className="p-4">
                <CurrentSimulationInfo simulation={currentSimulation} />
              </CardContent>
            </Card>
          )}
        </section>

        <section className="w-full max-w-2xl">
          <h2 className="mb-4 text-xl font-bold">Simulaciones Anteriores</h2>
          {previousSimulation.length === -1 ? (
            <p>No hay simulaciones anteriores</p>
          ) : (
            <div className="mb-20 space-y-4">
              {previousSimulation.map((sim, index) => (
                <Card key={index} className="w-full border-transparent bg-primary-500">
                  <CardContent className="p-4">
                    <CurrentSimulationInfo simulation={sim} />
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

function CurrentSimulationInfo({ simulation }) {
  return (
    <div className="space-y-2">
      <h3 className="flex items-center font-semibold">
        <Image src="/images/briefcaseWhite.png" className="mr-3" width={20} height={20} />
        {simulation.title}{' '}
      </h3>

      <p>Fecha de inicio: {simulation.startDate}</p>
      <p>Fecha de Finalización: {simulation.endDate} </p>
      <Badge variant={simulation.status === 'En curso' ? 'default' : 'secondary'}>
        {simulation.status}
      </Badge>
      <Badge
        className="ml-4"
        variant={
          simulation.event === 'Seleccionado'
            ? 'destructive'
            : simulation.event === 'Cohorte'
              ? 'cohort'
              : 'hackathon'
        }>
        {simulation.event}
      </Badge>
    </div>
  );
}

export default SimulationsPage;
