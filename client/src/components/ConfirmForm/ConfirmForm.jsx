'use client';
import { updateProfile } from './action';
import style from '../../styles/signup.module.css';
import FormComponent from '../Form/FormComponent';
import { registerStepTwo } from '@/constants/authFields';

export const ConfirmForm = () => {
  return (
    <section className={style.signup}>
      <h2 className={style.signupSubtitle}>Completa estos campos para personalizar tu perfil.</h2>
      <FormComponent
        fields={registerStepTwo}
        className="relative mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[4.25rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Continuar"
        onSubmit={updateProfile}
      />
    </section>
  );
};
