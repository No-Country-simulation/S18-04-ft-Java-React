'use client';

import { useRef } from 'react';
import { useFormState } from 'react-dom';
import { projectTypeSelect } from './action';
import { ProjectCard } from '../ProjectCard/ProjectCard';
import { colors, DATABI_ITEM, ITEMS, NOCODE_ITEM } from '@/constants/projectTypeItems';

const getItems = name => {
  if (name === 'WebApp' || name === 'Mobile') return ITEMS;
  else if (name === 'NoCode') return NOCODE_ITEM;

  return DATABI_ITEM;
};

export const SelectProjectTypeForm = ({ projects }) => {
  const [result, dispatch] = useFormState(projectTypeSelect, undefined);
  const formRef = useRef();

  const handleSubmit = event => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    dispatch(formData);
  };

  return (
    <form
      ref={formRef}
      id="selectProjectType"
      data-testid="selectProjectType"
      action={dispatch}
      className="mx-auto my-12 flex size-full max-w-4xl flex-row flex-wrap items-center justify-center gap-4 px-8">
      {projects.map((project, i) => (
        <ProjectCard
          key={project.id}
          id={project.id}
          color={colors[i]}
          h1={project.projectTypeName}
          h2="Integrado por:"
          desc={project.projectTypeDescription}
          items={getItems(project.projectTypeName)}
          name="projectTypeId"
          form={formRef.current}
        />
      ))}
    </form>
  );
};
