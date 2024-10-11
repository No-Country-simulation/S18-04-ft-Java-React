'use client';
import Image from 'next/image';
// import { useEffect, useTransition } from 'react';
// import { useFormState } from 'react-dom';
// import { signup } from './action';
import style from '../../styles/signup.module.css';

// **Este componente solo es ejemplo**

/**
 Como se ve al principio del archivo esta el string 'use client'
 Esto se le llama directiva, y sirve para indicar que este componente se ejecutara del lado del cliente
 Se necesita ejecutar del lado del cliente debido a que utiliza eventos del navegador
 No disponibles en el cliente

 En este caso se utilizan los hooks 'useEffect', 'useTransition', 'useFormState', solo disponibles en el cliente y ademas tambien el evento 'onSubmit' solo disponible en el cliente(Todos los eventos de js solo estan disponibles en el cliente, APIS como window o document tambien)
 */
export const SignupForm = () => {
  // Este hook de vuelva un 'wrapper' del action
  // Basicamente lo que hace es devolver una nueva funcion que llamo 'dispatch'
  // que se ejecuta en el cliente recibe los datos del formulario
  // y ejecuta la funcion 'signup' del lado del servidor
  // El segundo parametro 'result' es la respuesta(return) de la funcion 'signup'
  // const [result, dispatch] = useFormState(signup, undefined);
  // const [isPending, startTransition] = useTransition();

  // useEffect(() => {
  //   if (result) {
  //     // De esta forma se asegura el RESET de isPending
  //     startTransition(() => {});
  //   }
  // }, [result]);

  // const handleSubmit = event => {
  //   //Prevent default para evitar que recargue la pagina (accion por defecto)
  //   event.preventDefault();
  //   const formData = new FormData(event.currentTarget);
  //   // start transition es una funcion que se utiliza, para indicar una transicion
  //   // desde que se inicia a ejecutar hasta que se termine de ejecutar
  //   // En este caso la transicion es mientras se ejecuta 'dispatch"
  //   startTransition(() => dispatch(formData));
  // };

  return (
    <section className={style.signup}>
      <div className={style.signupContentLogo}>
        <Image
          className={style.signupLogo}
          src="/images/noCountryLogo.png"
          alt="No Country logo"
          width={56}
          height={46}
        />
        <Image src="/images/noCountry.png" alt="No Country" width={66} height={16} />
      </div>
      <form className={style.signupFormContent}>
        <fieldset className={style.signupFieldSet}>
          <div className={style.signupContent}>
            <div className={style.signupContentLabel}>
              <label className={style.signupLabel} htmlFor="userField">
                Usuario
                <input className={style.signupInput} id="user" type="text" name="userField" />
              </label>
            </div>

            <div className={style.signupContentLabel}>
              <label className={style.signupLabel} htmlFor="passwordField">
                Contraseña
                <input
                  className={style.signupInput}
                  id="password"
                  type="password"
                  name="passwordField"
                />
              </label>
            </div>
            <div className={style.signupContentLabel}>
              <label className={style.signupLabel} htmlFor="repeatPasswordField">
                Repetir contraseña
                <input
                  className={style.signupInput}
                  id="repeat"
                  type="password"
                  name="repeatPasswordField"
                />
              </label>
            </div>
          </div>

          <button className={style.signupButton} type="submit">
            Continuar
          </button>
        </fieldset>
      </form>
    </section>
  );
};
