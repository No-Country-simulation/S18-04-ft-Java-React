'use client';

import { useEffect, useTransition } from 'react';
import { useFormState } from 'react-dom';
import { signin } from './action';
import Image from 'next/image';
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
        
          <div className="inputWrapper">
            <label className='labelForm' htmlFor="emailField">Usuario</label>
            
              
              <input
                id="emailField"
                type="email"
                name="emailField"
                className="inputField"
                // placeholder="Ingresa tu usuario"
              />
          </div>
    
          <div className="inputWrapper">
            <label className='labelForm' htmlFor="passwordField">Contraseña</label>
            
              <input
                id="passwordField"
                type="password"
                name="passwordField"
                className="inputField"
                // placeholder="Ingresa tu contraseña"
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

          <div className="line-container">
              <hr class="styled-hr" />
                      <p> O </p>
              <hr class="styled-hr" />
          </div>

          <div className="socialIcons">
            <Image width={30} height={30}  src="/images/iconGoogle.png" alt="Google" />
            <Image width={30} height={30}  src="/images/iconFace.png" alt="Facebook" />
            <Image width={30} height={30}  src="/images/iconMac.png" alt="Apple" />
          </div>
        </form>
      </div>
    </div>
  );
};
