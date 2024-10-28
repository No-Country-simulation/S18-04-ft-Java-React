export const mapFormItems = (field, formItems) => {
  const { roles = [], languages = [], schedules = [], frameworks = [] } = formItems;

  const mappings = {
    rolField: {
      defaultValue: roles[0]?.id || '',
      items: roles.map(role => ({
        placeholder: role.roleTypeName,
        value: role.id,
      })),
    },
    languageField: {
      defaultValue: languages[0]?.id || '',
      items: languages.map(lang => ({
        placeholder: lang.languageName,
        value: lang.id,
      })),
    },
    timeAvailabilityField: {
      defaultValue: schedules[0] || '',
      items: schedules.map(schedule => ({
        placeholder: `Turno ${schedule === 'Manana' ? 'Mañana' : schedule}`,
        value: schedule,
      })),
    },
    frameworksFields: {
      defaultValue: frameworks[0]?.id || '',
      items: frameworks.map(framework => ({
        placeholder: framework.frameworkName,
        value: framework.id,
      })),
    },
  };

  return mappings[field.id] ? { ...field, ...mappings[field.id] } : field;
};
