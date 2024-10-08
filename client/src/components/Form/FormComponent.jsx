'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import Button from '../Button/Button';
import FormField from '../FormField/FormField';

// TODO: Implementar logica para, utilizar textarea y dropdowns
const RenderFields = ({ field, error }) => {
  const commonProps = {
    id: field.id,
    'data-testid': field.id,
    name: field.name,
    label: field.label,
    defaultValue: field.defaultValue || '',
    autoComplete: field.autoComplete || 'off',
    error: error,
  };

  return <FormField {...commonProps} type={field.type} />;
};

// Ejemplo de como hacer un formulario generico
// le pasas un array con los "fields" para armarmar los inputs
// Y un funcion "onSubmit" que puede ser un action para ejecutar al hacer un submit
export default function FormComponent({
  fields,
  onSubmit,
  btnText = 'Continuar',
  className = '',
  btnClassName = '',
  id,
}) {
  const [result, dispatch] = useFormState(onSubmit, undefined);
  const [isPending, startTransition] = useTransition();

  useEffect(() => {
    if (result) {
      // De esta forma se asegura el RESET de isPending
      startTransition(() => {});
    }
  }, [result]);

  const handleSubmit = event => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    startTransition(() => dispatch(formData));
  };

  return (
    <form
      id={id}
      data-testid={id}
      onSubmit={handleSubmit}
      className={`${className} flex flex-col gap-y-9`}
      method="post">
      {fields.map(field => (
        <RenderFields key={field.name} field={field} error={result?.errors?.[field.name]} />
      ))}
      <Button
        type="submit"
        size="full"
        key={`${id}-${isPending}`}
        disabled={isPending}
        className={btnClassName}
        tabIndex={Number(fields.at(-1)?.tabIndex || 0) + 1}>
        {btnText}
      </Button>
    </form>
  );
}
