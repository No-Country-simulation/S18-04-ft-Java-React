export const validateSchema = (schema, data) => {
  const schemaVerified = schema.safeParse(data);
  if (!schemaVerified.success) {
    const errors = Object.fromEntries(
      schemaVerified.error.errors
        .filter(({ path }) => path)
        .map(({ path, message }) => [path[0], message])
    );
    return [
      {
        id: crypto.randomUUID(),
        status: 'VALIDATION_ERROR',
        errors,
      },
      undefined,
    ];
  }
  return [undefined, schemaVerified.data];
};
