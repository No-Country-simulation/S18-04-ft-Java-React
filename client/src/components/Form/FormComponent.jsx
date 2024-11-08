'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import Button from '../Button/Button';
import { FormAsk } from '../FormAsk/FormAsk';
import { FormDropdown } from '../FormDropdown/FormDropdown';
import FormField from '../FormField/FormField';
import { FormStack } from '../FormStack/FormStack';
import PasswordFormField from '../PasswordField/PasswordField';
import { cn } from '@/lib/utils';

const RenderFields = ({ field, error }) => {
  const commonProps = {
    autoComplete: field.autoComplete || 'off',
    error,

    id: field.id,
    'data-testid': field.id,
    name: field.name,
    label: field.label,
    defaultValue: field.defaultValue || '',
    icon: field.icon,
    tabIndex: field.tabindex,
  };
  if (field.type === 'password') {
    return <PasswordFormField {...commonProps} activeForgot={field?.activeForgot} />;
  }
  if (field.type === 'dropdown') {
    return <FormDropdown {...commonProps} placeholder={field?.placeholder} items={field?.items} />;
  }
  if (field.type === 'stack') {
    return <FormStack {...commonProps} />;
  }
  if (field.type === 'ask') {
    return <FormAsk {...commonProps} items={field?.items} />;
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
      className={cn(className, 'relative flex w-full max-w-3xl flex-col gap-y-7')}>
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
      {!result?.errors && result ? <span>{result}</span> : null}
      {result?.errors && result.errors?.GLOBAL ? (
        <span className="left-30 absolute -bottom-6 text-sm text-red-400">
          {result.errors.GLOBAL}
        </span>
      ) : null}
    </form>
  );
}
