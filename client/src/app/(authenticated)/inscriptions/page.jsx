import { SimulationTypeForm } from '@/components/SimulationTypeForm/SimulationTypeForm';
import { getProjectType } from '@/data/getProjectType';

export default async function FormInscriptions() {
  const projects = await getProjectType();
  return (
    <div className="flex size-full flex-col">
      <SimulationTypeForm projects={projects} />
    </div>
  );
}
