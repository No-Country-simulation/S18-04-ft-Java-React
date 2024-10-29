import { sendInscription } from './action';
import css from './inscription.module.css';
import FormComponent from '../Form/FormComponent';
import { inscriptionFields } from '@/constants/inscriptionFields';
import { mapFormItems } from '@/lib/mapFormItems';

export const InscriptionForm = ({ formItems }) => {
  if (!formItems || typeof formItems !== 'object') {
    console.error('formItems debe ser un objeto válido');
    return (
      <div className="mb-4 mt-20 w-full p-8 text-center text-2xl font-medium text-red-500">
        No se pudieron cargar los datos del formulario
      </div>
    );
  }
  const mappedFields = inscriptionFields.map(field => mapFormItems(field, formItems));
  const hasValidFields = mappedFields.every(field => (field.items ? field.items.length > 0 : true));
  if (!hasValidFields) {
    console.error('Algunos campos requeridos están vacíos');
    return (
      <div className="mb-4 mt-20 w-full p-8 text-center text-2xl font-medium text-red-500">
        Faltan datos necesarios para el formulario
      </div>
    );
  }

  return (
    <div className={css.inscriptionContainer}>
      <FormComponent
        id="inscriptionForm"
        className="mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[2rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        fields={mappedFields}
        btnText="Inscribirme"
        onSubmit={sendInscription}
      />
    </div>
  );
};
