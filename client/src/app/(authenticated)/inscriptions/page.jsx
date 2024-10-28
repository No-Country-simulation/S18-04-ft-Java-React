import { SimulationTypeForm } from '@/components/SimulationTypeForm/SimulationTypeForm';
import { forbidenValidate } from '@/data/forbidenValidate';
import { getProjectType } from '@/data/getProjectType';

export default async function FormInscriptions() {
  const projects = await getProjectType();
  await forbidenValidate(projects.status);
  return (
    <div className="flex size-full flex-1 flex-col">
      <SimulationTypeForm projects={projects.data} />
    </div>
  );
}
