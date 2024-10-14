import { SigninForm } from '@/components/SigninForm/SigninForm';

const SignInPage = () => (
  <section className="flex size-full flex-col items-center justify-center">
    <h1 className="sr-only">Iniciar sesion</h1>
    <SigninForm />
  </section>
);

export default SignInPage;
