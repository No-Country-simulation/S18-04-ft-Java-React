'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import Button from '../Button/Button';
import FormField from '../FormField/FormField';
import PasswordFormField from '../PasswordField/PasswordField';
import { cn } from '@/lib/utils';

// TODO: Implementar logica para, utilizar textarea y dropdowns
const RenderFields = ({ field, error }) => {
  const commonProps = {
    id: field.id,
    'data-testid': field.id,
    name: field.name,
    label: field.label,
    defaultValue: field.defaultValue || '',
    autoComplete: field.autoComplete || 'off',
    error,
    icon: field.icon,
    tabIndex: field.tabindex,
  };
  if (field.type === 'password') {
    return <PasswordFormField {...commonProps} activeForgot={field?.activeForgot} />;
  }
  return <FormField {...commonProps} type={field.type} />;
};

export default function FormComponent({
  fields = [],
  onSubmit = (_, __) => {},
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
  //TODO: El formulario agregale la clase "relative"
  return (
    <form
      id={id}
      data-testid={id}
      onSubmit={handleSubmit}
      className={cn(className, 'flex w-full max-w-3xl flex-col gap-y-7')}>
      {fields.map(field => (
        <RenderFields key={field.name} field={field} error={result?.errors?.[field.name]} />
      ))}
      <Button
        type="submit"
        size="full"
        disabled={isPending}
        className={cn(
          'mt-8 max-w-[380px] focus-visible:outline-1 focus-visible:outline-accent-50',
          btnClassName
        )}
        tabIndex={Number(fields.at(-1)?.tabindex || 0) + 1}>
        {btnText}
      </Button>
      {/* TODO: Podes estilizar el span para que el mensaje de error global aparezca centrado */}
      {result?.errors && result.errors?.GLOBAL ? (
        <span className="absolute -bottom-6 left-0 text-sm text-red-400">
          {result.errors.GLOBAL}
        </span>
      ) : null}
    </form>
  );
}
