'use client';
import Image from 'next/image';
import { useRouter } from 'next/navigation';
import React from 'react';
import Button from '../Button/Button';
import Form from '../Form/Form';
import Input from '../Input/Input';
import style from '@/styles/signup.module.css';

function ConfirmForm() {
  const router = useRouter();

  const handlePreviousForm = () => {
    router.push('/signup');
  };
  return (
    <section className={[style.signup, style.signupMargin].join(' ')}>
      <Image
        className={style.signupArrow}
        src="/images/arrowLeft.png"
        width={20}
        height={20}
        onClick={handlePreviousForm}
        alt="botón para regresar al formulario anterior"
      />
      <h4 className={style.signupSubtitle}>Completa estos campos para personalizar tu perfil.</h4>
      <Form>
        <div className={style.signupContent}>
          <Input id="firstName" label="Nombre" autoComplete="new-name" />
          <Input id="lastName" label="Apellido" autoComplete="new-last-name" />
          <Input id="linkedin" label="Linkedin" iconLeft="/images/linkedin.png" />
          <Input id="github" label="GitHub" iconLeft="/images/github.png" />
        </div>
        <Button name="Aceptar" type="submit" />
      </Form>
    </section>
  );
}

export default ConfirmForm;
