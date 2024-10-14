'use client';
import Image from 'next/image';
// import { useEffect, useTransition } from 'react';
// import { signup } from './action';
import { useRouter } from 'next/navigation';
import { useState } from 'react';
import style from '../../styles/signup.module.css';
import Button from '../Button/Button';
import { Divider } from '../Divider/Divider';
import Form from '../Form/Form';
import Input from '../Input/Input';

export const SignupForm = () => {
  const [passwordVisibility, setPasswordVisibility] = useState({
    passwordOne: false,
    passwordtwo: false,
  });

  const [formValues, setFormValues] = useState({ passwordOne: '', passwordTwo: '' });

  const router = useRouter();

  const togglePasswordVisibility = field => {
    setPasswordVisibility(prevState => ({
      ...prevState,
      [field]: !prevState[field],
    }));
  };

  const handleSubmit = evt => {
    evt.preventDefault();
    router.push('/signupConfirm');
  };

  const handleChange = evt => {
    const { name, value } = evt.target;
    setFormValues(prevValues => ({
      ...prevValues,
      [name]: value,
    }));
  };

  return (
    <div className={style.signup}>
      <Form onSubmit={handleSubmit}>
        <div className={style.signupContent}>
          <Input
            id="user"
            iconLeft="/images/user.png"
            label="Usuario"
            type="email"
            autoComplete="new-email"
          />
          <Input
            id="passwordOne"
            name="passwordOne"
            iconLeft="/images/unlock.png"
            iconRight={passwordVisibility.passwordOne ? '/images/eyeOn.png' : '/images/eyeOff.png'}
            label="Contraseña"
            type={passwordVisibility.passwordOne ? 'text' : 'password'}
            onIconRightClick={() => togglePasswordVisibility('passwordOne')}
            value={formValues.passwordOne}
            onChange={handleChange}
            autoComplete="new-password"
          />

          <Input
            id="passwordTwo"
            name="passwordTwo"
            iconLeft="/images/unlock.png"
            iconRight={passwordVisibility.passwordTwo ? '/images/eyeOn.png' : '/images/eyeOff.png'}
            label="Repetir Contraseña"
            type={passwordVisibility.passwordTwo ? 'text' : 'password'}
            onIconRightClick={() => togglePasswordVisibility('passwordTwo')}
            value={formValues.passwordTwo}
            onChange={handleChange}
            autoComplete="new-password"
          />
        </div>

        <Button name="Continuar" type="submit" />
      </Form>
      <Divider />
    </div>
  );
};
