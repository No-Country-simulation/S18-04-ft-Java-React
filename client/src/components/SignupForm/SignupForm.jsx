'use client';
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
        btnClassName="mt-[4.25rem] mb-[2.70rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Continuar"
        onSubmit={signup}
      />
      <Divider />
      <SocialButtons />
    </section>
  );
};
