'use client';
import style from '../../styles/signup.module.css';
import FormComponent from '../Form/FormComponent';
import { registerStepTwo } from '@/constants/authFields';

export const ConfirmForm = () => {
  return (
    <section className={style.signup}>
      <FormComponent
        fields={registerStepTwo}
        className="relative mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[4.25rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Continuar"
        onSubmit={async () => {}}
      />
    </section>
  );
};
