'use server';

import { redirect } from 'next/navigation';
import { signupSchema } from '@/schemas/userSchema';

// Esta funcion se ejecuta del lado del servidor
// Se ejecuta al enviar el formulario en el "onSubmit" del form
export async function signup(_state, formData) {
  // "signupVerified" es el objeto validado por el esquema
  const signupVerified = signupSchema.safeParse({
    password: formData.get('passwordField'),
    email: formData.get('emailField'),
    name: formData.get('nameField'),
  });

  // Si success es false es que alguna de las validaciones fallo
  if (!signupVerified.success) {
    // De esta forma se extrean los mensajes de error
    // Se filtra para recuperar solo los campos que tuvieron fallos
    const errors = Object.fromEntries(
      signupVerified.error.errors
        .filter(({ path }) => path)
        .map(({ path, message }) => [path[0], message])
    );
    return {
      id: crypto.randomUUID(),
      status: 'VALIDATION_ERROR',
      errors,
    };
  }
  // Si el objeto no tuvo el error de validacion se hace la peticion a la API
  // (Esta peticion es de ejemplo, se remplazaria con la real, igual los datos del formulario son de ejemplo)
  const res = await fetch('/api/signup', {
    method: 'POST',
    body: JSON.stringify({
      email: signupVerified.data.email,
      password: signupVerified.data.password,
      name: signupVerified.data.name,
    }),
  });

  // Validar la respuesta de la API si falla enviar la respuesta de error
  if (!res.ok) {
    return {
      id: crypto.randomUUID(),
      status: 'FETCH_ERROR',
      errors: 'Algun error',
    };
  }

  // Ejecutar la logica en caso que el registro sea exitoso
  // (En este caso se redirecciona a la pagina de inicio)
  redirect('/');
}
