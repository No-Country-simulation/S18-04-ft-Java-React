import { SigninForm } from "@/components/SigninForm/SigninForm";

// Este componente se vera en la ruta /signin (Nombre de la carpeta)
const SignInPage = () => {
  return (
    <div>
      <main style={{margin: '0 auto', padding: '5rem'}}>
        <SigninForm/>
      </main>
    </div>
  );
};

export default SignInPage;
