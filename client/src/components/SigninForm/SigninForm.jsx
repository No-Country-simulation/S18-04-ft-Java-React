'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import { signin } from './action';
import './stylesLogin.css';

export const SigninForm = () => {
  const [result, dispatch] = useFormState(signin, undefined);
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
    <div className="containerLogin">
      <div className="divLogo">
        <img className='logo' src="images/logo.png" alt="Logo" />
      </div>
      <h6 className="titleGradient">Transformando talento en experiencia</h6>
      <div className="formWrapper">
        <form className="formLogin" onSubmit={handleSubmit}>
        <label htmlFor="emailField">Usuario</label>
          <div className="inputWrapper">
            
            <input
              id="emailField"
              type="email"
              name="emailField"
              className="inputField"
              placeholder="Ingresa tu usuario"
            />
          </div>
          <label htmlFor="passwordField">Contraseña</label>
          <div className="inputWrapper">
           
            <input
              id="passwordField"
              type="password"
              name="passwordField"
              className="inputField"
              placeholder="Ingresa tu contraseña"
            />
          </div>
          <a href="#" className="forgotPassword">¿Olvidaste tu contraseña?</a>
          <button
            type="submit"
            disabled={isPending}
            className="submitButton"
          >
            Iniciar Sesión
          </button>
          <div className="socialIcons">
            <img className='iconLogin' src="images/iconGoogle.png" alt="Google" />
            <img className='iconLogin' src="images/iconFace.png" alt="Facebook" />
            <img className='iconLogin' src="images/iconMac.png" alt="Apple" />
          </div>
        </form>
      </div>
    </div>
  );
};
