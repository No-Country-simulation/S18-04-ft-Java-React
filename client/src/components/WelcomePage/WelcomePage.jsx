'use client';
import { useRouter } from 'next/navigation';
import React from 'react';
import Button from '../Button/Button';
import style from '@/styles/welcome.module.css';

function WelcomePage() {
  const router = useRouter();

  const handleRouteSignin = () => {
    router.push('/signin');
  };

  const handleRouteSignup = () => {
    router.push('/signup');
  };

  return (
    <div className={style.welcome}>
      <h3 className={style.welcomeTitle}>
        Bienvenido a <span className={style.welcomeTitleSpan}>No Country</span>
      </h3>
      <p className={style.welcomeParagraph}>
        Conéctate con el mundo tech a través de proyectos reales y simulaciones laborales. Aprende,
        crece y construye tu camino profesional junto a una comunidad que impulsa tu talento.
      </p>

      <div className={style.welcomeContentButton}>
        <button className={style.welcomeButton} onClick={handleRouteSignin}>
          Iniciar sesión
        </button>

        <button
          className={[style.welcomeButton, style.welcomeButtonColor].join(' ')}
          onClick={handleRouteSignup}>
          Registrarse
        </button>
      </div>
    </div>
  );
}

export default WelcomePage;
