import * as Select from '@radix-ui/react-select';
import Image from 'next/image';
import { forwardRef } from 'react';
import { cn } from '@/lib/utils';

export const FormDropdown = ({
  placeholder = '',
  tabIndex,
  icon,
  label,
  name,
  id,
  defaultValue,
  items = [],
}) => {
  return (
    <div className="dropdown relative z-0 flex w-full min-w-full flex-col text-base font-normal leading-4 text-white">
      <label className="mb-4">{label}</label>
      <Select.Root
        dir="ltr"
        id={id}
        data-testid={id}
        className="group relative w-full max-w-lg"
        defaultValue={defaultValue}
        name={name}>
        <Select.Trigger
          type="button"
          tabIndex={tabIndex}
          aria-label="Roles de usuario"
          className="no-outline ease border-gradient relative z-20 flex h-12 w-full justify-between rounded-md bg-transparent px-3 py-2 text-base transition-all duration-300 [&:is([data-state='open'])]:shadow-[0px_2px_22px_rgba(14,252,162,0.25)]">
          <Select.Value placeholder={placeholder} />
          {icon ? (
            <Select.Icon asChild>
              <Image
                src={icon}
                width={20}
                height={20}
                alt="Chevron icon"
                className="aspect-square"
              />
            </Select.Icon>
          ) : null}
        </Select.Trigger>
        <Select.Content
          asChild
          side="bottom"
          position="popper"
          sideOffset={10}
          hideWhenDetached={false}
          className="no-outline border-gradient flex w-full min-w-[var(--radix-select-trigger-width)] flex-col bg-primary-500 transition-all ease-in">
          <div className="pointer-events-all relative box-border">
            <Select.Viewport asChild>
              <div className="flex max-h-[360px] flex-col gap-y-0 overflow-auto">
                {items.map((item, i) => (
                  <SelectItem
                    key={i}
                    className="no-outline w-full cursor-pointer border-none p-3 hover:bg-primary-400/50 active:bg-primary-400/65"
                    value={item.value}
                    textValue={item.placeholder}>
                    {item.placeholder}
                  </SelectItem>
                ))}
              </div>
            </Select.Viewport>
          </div>
        </Select.Content>
      </Select.Root>
    </div>
  );
};

const SelectItem = forwardRef(function SelectItemRef(
  { children, className, value, ...props },
  forwardedRef
) {
  return (
    <Select.Item value={value} className={cn(className)} {...props} ref={forwardedRef}>
      <Select.ItemText>{children}</Select.ItemText>
    </Select.Item>
  );
});
