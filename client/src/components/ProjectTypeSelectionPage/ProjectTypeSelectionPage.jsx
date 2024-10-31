import { SelectProjectTypeForm } from '../SelectProjectTypeForm/SelectProjectTypeForm';
import { getProjectType } from '@/data/getProjectType';

export default async function ProjectTypeSelectionPage() {
  const projects = await getProjectType();

  return <SelectProjectTypeForm projects={projects.data} />;
}
