'use client';
import Image from 'next/image';
import { manageTeams } from './action';
import style from '../../styles/signup.module.css';
import FormComponent from '../Form/FormComponent';
import { manageTeamsFields } from '@/constants/manageTeamsFields';

export const ManageTeamsForm = () => {
  return (
    <div className={style.containerLogin}>
      <h1 className="mt-4 text-center text-xl">Asignación de equipos</h1>
      <div className="my-5 flex flex-row">
        <Image src="/images/eyeOn.svg" alt="Aviso" width={32} height={32} />
        <h2
          className={`text-gradient gradient-green-blue-300 ${style.titleGradient} ml-2 leading-normal`}>
          Advertencia: El siguiente formulario ejecutará el proceso de asignación de equipos, se
          recomienda asegurarse correctamente antes de enviar los datos del formulario, ya que el
          proceso crea y modifica la información de la base de datos con el fin de asignar los
          equipos.
        </h2>
      </div>
      <FormComponent
        fields={manageTeamsFields}
        onSubmit={manageTeams}
        className="mb-7 w-full items-center justify-center max-sm:max-w-[85%]"
        btnClassName="mt-[4.25rem] max-sm:max-w-[85%] mx-auto justify-center items-center"
        btnText="Asignar equipos"
      />
    </div>
  );
};
