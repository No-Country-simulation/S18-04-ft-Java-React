'use client';

import Link from 'next/link';
import { signup } from './action';
import style from '../../styles/signup.module.css';
import { Divider } from '../Divider/Divider';
import FormComponent from '../Form/FormComponent';
import { SocialButtons } from '../SocialButtons/SocialButtons';
import { registerStepOne } from '@/constants/authFields';

export const SignupForm = () => {
  return (
    <section className={style.signup}>
      <FormComponent
        fields={registerStepOne}
        className="relative mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[4.25rem]  max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Continuar"
        onSubmit={signup}
      />
      <Link
        className="text-sm font-medium transition-all ease-linear hover:text-accent-100 hover:underline"
        href="/signin">
        ¿Ya tienes una cuenta? Iniciar sesion
      </Link>
      <Divider />
      <SocialButtons />
    </section>
  );
};
