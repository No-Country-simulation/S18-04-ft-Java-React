export const FormAsk = ({ label, name, items, tabIndex, id }) => {
  return (
    <div
      data-testid={id}
      tabIndex={tabIndex}
      className="flex items-center justify-center gap-x-2 text-sm text-white">
      {label}
      <label
        htmlFor={items[0].id}
        data-state="idle"
        className="relative flex size-7 cursor-pointer items-center justify-center rounded-full border border-white p-1 transition-colors ease-in [&:has(input:checked)]:border-accent-300 [&:has(input:checked)]:text-accent-300">
        <input
          id={items[0].id}
          type="radio"
          name={name}
          value={items[0].value}
          required
          className="sr-only"
        />
        {items[0].placeholder}
      </label>

      <label
        htmlFor={items[1].id}
        data-state="idle"
        className="relative flex size-7 cursor-pointer items-center justify-center rounded-full border border-white p-1 transition-colors ease-in [&:has(input:checked)]:border-accent-300 [&:has(input:checked)]:text-accent-300">
        <input
          id={items[1].id}
          className="sr-only"
          type="radio"
          name={name}
          value={items[1].value}
          required
        />
        {items[1].placeholder}
      </label>
    </div>
  );
};
