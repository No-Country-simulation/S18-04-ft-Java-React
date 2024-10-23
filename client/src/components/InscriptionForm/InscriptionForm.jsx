import { sendInscription } from './action';
import css from './inscription.module.css';
import FormComponent from '../Form/FormComponent';
import { inscriptionFields } from '@/constants/inscriptionFields';

export const InscriptionForm = () => {
  return (
    <div className={css.inscriptionContainer}>
      <FormComponent
        id="inscriptionForm"
        className="mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[2rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        fields={inscriptionFields}
        btnText="Inscribirme"
        onSubmit={sendInscription}
      />
    </div>
  );
};
