import Image from 'next/image';
import { Badge } from '../Badge/Badge';

export default function SimulationInfo({ simulation }) {
  const participants = simulation.participants?.[0];
  const eventType = participants?.eventDescription.split(' ')[0];

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

      <p>Fecha de inicio: {participants?.eventDateStart}</p>
      <p>Fecha de Finalización: {participants?.eventDateEnd}</p>
      <Badge variant={simulation.state === 'Progress' ? 'default' : 'secondary'}>
        {simulation.state === 'Progress' ? 'En curso' : 'Finalizado'}
      </Badge>
      <Badge
        className="ml-4"
        variant={
          participants?.eventDescription === 'Seleccionado'
            ? 'destructive'
            : participants?.eventDescription === 'Cohorte'
              ? 'cohort'
              : 'hackathon'
        }>
        {eventType}
      </Badge>
    </div>
  );
}
