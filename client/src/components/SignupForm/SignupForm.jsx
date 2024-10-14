'use client';

import { useRouter } from 'next/navigation';
import style from '../../styles/signup.module.css';
import Button from '../Button/Button';
import { Divider } from '../Divider/Divider';
import Form from '../Form/Form';
import FormField from '../FormField/FormField';
import PasswordFormField from '../PasswordField/PasswordField';

export const SignupForm = () => {
  /* const [passwordVisibility, setPasswordVisibility] = useState({
    passwordOne: false,
    passwordtwo: false,
  });

  const [formValues, setFormValues] = useState({ passwordOne: '', passwordTwo: '' });*/

  const router = useRouter();

  /* const togglePasswordVisibility = field => {
    setPasswordVisibility(prevState => ({
      ...prevState,
      [field]: !prevState[field],
    }));
  };*/

  const handleSubmit = evt => {
    evt.preventDefault();
    router.push('/signupConfirm');
  };

  /*   const handleChange = evt => {
    const { name, value } = evt.target;
    setFormValues(prevValues => ({
      ...prevValues,
      [name]: value,
    }));
  };*/

  return (
    <div className={style.signup}>
      <Form onSubmit={handleSubmit}>
        <div className={style.signupContent}>
          <FormField
            id="user"
            name="user"
            icon="/images/user.png"
            label="Usuario"
            type="email"
            autoComplete="new-email"
          />
          <PasswordFormField
            id="passwordOne"
            name="passwordOne"
            icon="/images/unlock.png"
            label="Contraseña"
            autoComplete="new-password"
          />
          <PasswordFormField
            id="passwordTwo"
            name="passwordTwo"
            icon="/images/unlock.png"
            label="Contraseña"
            autoComplete="new-password"
          />
        </div>

        <Button type="submit">Continuar</Button>
      </Form>
      <Divider />
    </div>
  );
};
