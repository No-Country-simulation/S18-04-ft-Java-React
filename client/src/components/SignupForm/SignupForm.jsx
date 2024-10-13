'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import { signup } from './action';

// **Este componente solo es ejemplo**

/**
 Como se ve al principio del archivo esta el string "use client"
 Esto se le llama directiva, y sirve para indicar que este componente se ejecutara del lado del cliente
 Se necesita ejecutar del lado del cliente debido a que utiliza eventos del navegador
 No disponibles en el cliente

 En este caso se utilizan los hooks "useEffect", "useTransition", "useFormState", solo disponibles en el cliente y ademas tambien el evento "onSubmit" solo disponible en el cliente(Todos los eventos de js solo estan disponibles en el cliente, APIS como window o document tambien)
 */
export const SignupForm = () => {
  // Este hook de vuelva un "wrapper" del action
  // Basicamente lo que hace es devolver una nueva funcion que llamo "dispatch"
  // que se ejecuta en el cliente recibe los datos del formulario
  // y ejecuta la funcion "signup" del lado del servidor
  // El segundo parametro "result" es la respuesta(return) de la funcion "signup"
  const [result, dispatch] = useFormState(signup, undefined);
  const [isPending, startTransition] = useTransition();

  useEffect(() => {
    if (result) {
      // De esta forma se asegura el RESET de isPending
      startTransition(() => {});
    }
  }, [result]);

  const handleSubmit = event => {
    //Prevent default para evitar que recargue la pagina (accion por defecto)
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    // start transition es una funcion que se utiliza, para indicar una transicion
    // desde que se inicia a ejecutar hasta que se termine de ejecutar
    // En este caso la transicion es mientras se ejecuta "dispatch"
    startTransition(() => dispatch(formData));
  };

  // Formulario de ejemplo
  return (
    <form className="border-1 mx-auto flex max-w-2xl flex-col rounded-sm" onSubmit={handleSubmit}>
      <div className="flex flex-col gap-y-4">
        <div className="flex flex-col gap-y-2">
          <label htmlFor="emailField">
            Email
            <input id="emailField" type="email" name="emailField" />
          </label>
        </div>
        <div className="flex flex-col gap-y-2">
          <label htmlFor="nameField">
            Name
            <input id="nameField" type="text" name="nameField" />
          </label>
        </div>
        <div className="flex flex-col gap-y-2">
          <label htmlFor="passwordField">
            Email
            <input id="passwordField" type="password" name="passwordField" />
          </label>
        </div>
      </div>
      <button type="submit" disabled={isPending}>
        Submit
      </button>
    </form>
  );
};
