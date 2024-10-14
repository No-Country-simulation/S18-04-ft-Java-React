'use client';

import Link from 'next/link';
import Button from '../Button/Button';
import style from '@/styles/welcome.module.css';

export default function WelcomePage() {
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
        <Button asChild>
          <Link href="/signin" className="w-full max-w-[244px]">
            Iniciar sesión
          </Link>
        </Button>
        <Button variant="secondary" asChild>
          <Link href="/signup" className="w-full max-w-[244px]">
            Registrarse
          </Link>
        </Button>
      </div>
    </div>
  );
}
