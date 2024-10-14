import { signin } from './action';
import css from './stylesLogin.module.css';
import { Divider } from '../Divider/Divider';
import FormComponent from '../Form/FormComponent';
import { SocialButtons } from '../SocialButtons/SocialButtons';
import { loginFields } from '@/constants/authFields';

export const SigninForm = () => {
  return (
    <div className={css.containerLogin}>
      <h2 className={`text-gradient gradient-green-blue-300 ${css.titleGradient}`}>
        Transformando talento en experiencia
      </h2>
      <FormComponent
        fields={loginFields}
        onSubmit={signin}
        className="mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[4.25rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Iniciar Sesion"
      />
      <Divider />
      <SocialButtons />
    </div>
  );
};
