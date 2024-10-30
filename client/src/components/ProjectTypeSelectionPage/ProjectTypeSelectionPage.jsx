import { SimulationTypeForm } from '../SimulationTypeForm/SimulationTypeForm';
import { getProjectType } from '@/data/getProjectType';

export default async function ProjectTypeSelectionPage() {
  const projects = await getProjectType();

  return <SimulationTypeForm projects={projects.data} />;
}
